package com.github.cukedoctor;

import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.FileUtil;
import org.asciidoctor.Asciidoctor;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by pestano on 22/02/16.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
public class CukedoctorBenchmark {

    private static CukedoctorConverter cukedoctorConverter;
    private static List<Feature> asciidoctorFeatures;
    private static Asciidoctor asciidoctor;


    @State(Scope.Thread)
    public static class BenchmarkContext {

        @Setup
        public void init() throws RunnerException {
            Logger.getLogger(FileUtil.class.getName()).setLevel(Level.SEVERE);
            String asciidoctorFeaturesPath = FileUtil.findJsonFile(CukedoctorBenchmark.class.getResource("/asciidoctor-features.json").getPath());
            asciidoctorFeatures = FeatureParser.parse(asciidoctorFeaturesPath);
            cukedoctorConverter = Cukedoctor.instance(asciidoctorFeatures);
        }


    }

    @Benchmark
    public void convert(BenchmarkContext ctx) {
        String livingDocumentation = cukedoctorConverter.renderDocumentation();
        File adocFile = FileUtil.saveFile("target/benchmark/" + UUID.randomUUID().toString() + ".adoc", livingDocumentation);
        //Asciidoctor.Factory.create().convertFile(adocFile, org.asciidoctor.OptionsBuilder.options().backend("html").safe(SafeMode.UNSAFE).asMap());
    }


    public static void main(String[] args) throws RunnerException, InterruptedException {
        try {
            new Runner(new OptionsBuilder().
                    forks(3).
                    threads(8).
                    warmupIterations(5).
                    warmupForks(1).
                    measurementIterations(10).
                    include(CukedoctorBenchmark.class.getSimpleName()).
                    measurementTime(TimeValue.milliseconds(350)).
                    build()
            ).run();
        }finally {
            List<String> files = FileUtil.findFiles("target/benchmark", ".adoc");
            Logger.getLogger(CukedoctorBenchmark.class.getName()).info("Number of files converted: " + files.size());
            CukedoctorBenchmark.removeAdocFIles();
        }

    }

    private static void removeAdocFIles() {
        List<String> files = FileUtil.findFiles("target/benchmark", ".adoc");
        if (files != null) {
            for (String file : files) {
                FileUtil.removeFile(file);
            }
        }
    }

}
