package com.zhang.db.function;

public interface DTOConvert<S, T> {
    T convert(S s);
}
