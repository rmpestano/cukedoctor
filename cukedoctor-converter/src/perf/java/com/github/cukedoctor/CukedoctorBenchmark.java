package com.github.cukedoctor;

import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.FileUtil;
import java.io.File;
import java.util.List;
import java.util.UUID;
import org.asciidoctor.Asciidoctor;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by pestano on 22/02/16.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
public class CukedoctorBenchmark {

    private static final Logger log = LoggerFactory.getLogger(CukedoctorBenchmark.class);

    private static CukedoctorConverter cukedoctorConverter;
    private static List<Feature> asciidoctorFeatures;
    private static Asciidoctor asciidoctor;


    @State(Scope.Thread)
    public static class BenchmarkContext {

        @Setup
        public void init() {
            System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "error");
            String asciidoctorFeaturesPath = FileUtil.findJsonFile(CukedoctorBenchmark.class.getResource("/asciidoctor-features.json").getPath());
            asciidoctorFeatures = FeatureParser.parse(asciidoctorFeaturesPath);
            cukedoctorConverter = Cukedoctor.instance(asciidoctorFeatures);
        }


    }

    @Benchmark
    public void convert(BenchmarkContext ctx) {
        String livingDocumentation = cukedoctorConverter.renderDocumentation();
        File adocFile = FileUtil.saveFile("target/benchmark/" + UUID.randomUUID() + ".adoc", livingDocumentation);
        //Asciidoctor.Factory.create().convertFile(adocFile, org.asciidoctor.OptionsBuilder.options().backend("html").safe(SafeMode.UNSAFE).asMap());
    }


    public static void main(String[] args) throws RunnerException {
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
            log.info("Number of files converted: {}", files.size());
            CukedoctorBenchmark.removeAdocFIles();
        }
    }

    private static void removeAdocFIles() {
        FileUtil.findFiles("target/benchmark", ".adoc")
            .forEach(FileUtil::removeFile);
    }

}
