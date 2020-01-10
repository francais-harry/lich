/*
 * Copyright 2020 LINE Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.linecorp.lich.sample.feature

import android.content.Context
import com.linecorp.lich.component.ComponentFactory
import com.linecorp.lich.component.getComponent
import com.linecorp.lich.sample.ApplicationGraph
import com.linecorp.lich.sample.feature.viewmodel.SampleFeatureViewModelsGraph
import dagger.Component

/**
 * A Dagger [Component] for the object graph of the `dagger_sample_feature` subproject.
 */
@SampleFeatureScope
@Component(dependencies = [ApplicationGraph::class])
interface SampleFeatureGraph {

    fun viewModelsGraphFactory(): SampleFeatureViewModelsGraph.Factory

    @Component.Factory
    interface Factory {
        fun create(applicationGraph: ApplicationGraph): SampleFeatureGraph
    }

    companion object : ComponentFactory<SampleFeatureGraph>() {
        override fun createComponent(context: Context): SampleFeatureGraph =
            DaggerSampleFeatureGraph.factory().create(context.getComponent(ApplicationGraph))
    }
}
