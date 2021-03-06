/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.workbench.forms.display.backend.provider;

import org.jbpm.workbench.forms.service.providing.FormProvider;
import org.jbpm.workbench.forms.service.providing.ProcessRenderingSettings;
import org.jbpm.workbench.forms.service.providing.TaskRenderingSettings;
import org.jbpm.workbench.forms.display.api.KieWorkbenchFormRenderingSettings;

public abstract class AbstractKieWorkbenchFormsProvider implements FormProvider<KieWorkbenchFormRenderingSettings> {

    protected ProcessFormsValuesProcessor processFormsValuesProcessor;

    protected TaskFormValuesProcessor taskFormValuesProcessor;

    public AbstractKieWorkbenchFormsProvider(ProcessFormsValuesProcessor processFormsValuesProcessor,
                                             TaskFormValuesProcessor taskFormValuesProcessor) {
        this.processFormsValuesProcessor = processFormsValuesProcessor;
        this.taskFormValuesProcessor = taskFormValuesProcessor;
    }

    @Override
    public KieWorkbenchFormRenderingSettings render(ProcessRenderingSettings settings) {
        return processFormsValuesProcessor.generateRenderingContext(settings);
    }

    @Override
    public KieWorkbenchFormRenderingSettings render(TaskRenderingSettings settings) {
        return taskFormValuesProcessor.generateRenderingContext(settings);
    }
}
