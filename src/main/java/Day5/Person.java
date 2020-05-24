package Day5;

public class Person {

}
/*
                    +-----------+
                    | Throwable |
                    +-----------+
                    /         \
                   /           \
          +-------+          +-----------+
          | Error |          | Exception |
          +-------+          +-----------+
            /  |  \           / |        \
         \________/      \______/         \
                             +------------------+
    unchecked     checked    | RuntimeException |
                             +------------------+
                              /   |    |      \
                             \_________________/

                               unchecked
* */