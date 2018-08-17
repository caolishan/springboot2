package com.example.springboot2;

import java.util.Map;

public interface ISpiProvider {
    Object exec(final Map<Object,Object> paraMap);
}
