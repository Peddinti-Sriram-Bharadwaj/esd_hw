package com.sriram9217.esdtask.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerNotFoundException  extends RuntimeException {
    private final String msg;
}
