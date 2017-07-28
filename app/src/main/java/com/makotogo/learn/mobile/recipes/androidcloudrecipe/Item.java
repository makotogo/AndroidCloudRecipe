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

public class Item extends AbstractEntity {

    private String description;
    private Date dueDate;
    private Boolean finished;
    private Category category;

    public String getDescription() {
        return description;
    }

    public Item withDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Item withDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Boolean getFinished() {
        return finished;
    }

    public Item withFinished(Boolean finished) {
        this.finished = finished;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Item withCategory(Category category) {
        this.category = category;
        return this;
    }

    @Override
    public Item withId(Long id) {
        super.withId(id);
        return this;
    }

    @Override
    public Item withWhenCreated(Date whenCreated) {
        super.withWhenCreated(whenCreated);
        return this;
    }

    @Override
    public Item withWhenLastUpdated(Date whenLastUpdated) {
        super.withWhenLastUpdated(whenLastUpdated);
        return this;
    }

}
