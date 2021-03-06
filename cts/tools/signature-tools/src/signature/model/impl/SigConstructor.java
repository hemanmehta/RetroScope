/*
 * Copyright (C) 2009 The Android Open Source Project
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

package signature.model.impl;

import java.io.Serializable;

import signature.model.IConstructor;
import signature.model.Modifier;
import signature.model.util.ModelUtil;

@SuppressWarnings("serial")
public class SigConstructor extends SigExecutableMember implements
        IConstructor, Serializable {

    public SigConstructor(String name) {
        super(name);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(" ");
        builder.append(Modifier.toString(getModifiers()));
        if (getTypeParameters() != null && !getTypeParameters().isEmpty()) {
            builder.append("<");
            builder.append(ModelUtil.separate(getTypeParameters(), ", "));
            builder.append("> ");
        }
        builder.append(getName());
        builder.append("(");
        builder.append(getParameters().isEmpty() ? "" : ModelUtil.separate(
                getParameters(), ", "));
        builder.append(")");
        if (getExceptions() != null && !getExceptions().isEmpty()) {
            builder.append(" throws ");
            builder.append(ModelUtil.separate(getExceptions(), " "));
        }
        return builder.toString();
    }
}
