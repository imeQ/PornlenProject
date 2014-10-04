package com.pornlen.domain

class DomainProvider {

    static Entity getRandomEntity() {

        Entity entity = new Entity(
                name: "name_" + new Random().nextInt(12),
                age: new Random().nextInt(100),
                nestedEntitiesBatch10: [
                        new NestedEntity(
                                nestedName: "nestedName_" + new Random().nextInt(12),
                                nestedAge: new Random().nextInt(100),
                        ),
                        new NestedEntity(
                                nestedName: "nestedName_" + new Random().nextInt(12),
                                nestedAge: new Random().nextInt(100),
                        )
                ],
                nestedEntitiesNoBatch: [
                        new NestedEntity(
                                nestedName: "nestedName_" + new Random().nextInt(12),
                                nestedAge: new Random().nextInt(100),
                        ),
                        new NestedEntity(
                                nestedName: "nestedName_" + new Random().nextInt(12),
                                nestedAge: new Random().nextInt(100),
                        )
                ]);
    }

    static User getRandomUser() {
        return new User(name: "userName" + +new Random().nextInt(100))
    }
}
