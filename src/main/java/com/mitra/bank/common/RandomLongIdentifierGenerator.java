package com.mitra.bank.common;

import java.io.Serializable;
import java.util.Random;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomLongIdentifierGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        Random random = new Random();
        return String.valueOf(Math.abs(random.nextLong()));
    }
}

