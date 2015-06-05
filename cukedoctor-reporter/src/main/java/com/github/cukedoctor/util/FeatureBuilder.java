package com.github.cukedoctor.util;

import com.github.cukedoctor.api.model.Feature;

/**
 * Created by pestano on 04/06/15.
 */
public class FeatureBuilder {

    private Feature feature;
    private static FeatureBuilder instance;


    private FeatureBuilder(Feature feature){
        this.feature = feature;
    }

    private Feature getFeature(){
        return feature;
    }

    public static synchronized FeatureBuilder instance(){
        instance = new FeatureBuilder(new Feature());
        return instance;
    }


    public FeatureBuilder id(String id){
        instance.getFeature().setId(id);
        return instance;
    }

    public FeatureBuilder name(String name){
        instance.getFeature().setName(name);
        return instance;
    }

    public FeatureBuilder uri(String uri){
        instance.getFeature().setUri(uri);
        return instance;
    }

    public FeatureBuilder description(String desc){
        instance.getFeature().setDescription(desc);
        return instance;
    }

    public Feature build(){
        return instance.getFeature();
    }
}
