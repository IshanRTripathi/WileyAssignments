package Day5;

public class Person {

}
/*
                    +-----------+
                    | Throwable |
                    +-----------+
                    /            \
                   /              \
          +-------+             +-----------+
          | Error |             | Exception |
          +-------+             +-----------+
               |                  |         \
               |                  |          \
               |                  |         +------------------+
          unchecked         checked         | RuntimeException |
                             ex- IOE        +------------------+
                                                    \
                                                     \
                                                   unchecked ex- Arithmetic

encapsulation => inheritance => abstraction => polymorphism
* */

