/*
 *  Copyright 2017 Makoto Consulting Group, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.makotogo.learn.mobile.recipes.androidcloudrecipe;

import java.util.Date;

public abstract class AbstractEntity {

    private Long id;

    private Date whenCreated;
    private Date whenLastUpdated;

    public Long getId() {
        return id;
    }

    AbstractEntity withId(Long id) {
        this.id = id;
        return this;
    }

    public Date getWhenCreated() {
        return whenCreated;
    }

    public AbstractEntity withWhenCreated(Date whenCreated) {
        this.whenCreated = whenCreated;
        return this;
    }

    public Date getWhenLastUpdated() {
        return whenLastUpdated;
    }

    public AbstractEntity withWhenLastUpdated(Date whenLastUpdated) {
        this.whenLastUpdated = whenLastUpdated;
        return this;
    }

}
