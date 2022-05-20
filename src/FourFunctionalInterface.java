@FunctionalInterface
public interface FourFunctionalInterface<T, S, F, M, R> {
    R apply(T t, S s, F f, M m);
}
