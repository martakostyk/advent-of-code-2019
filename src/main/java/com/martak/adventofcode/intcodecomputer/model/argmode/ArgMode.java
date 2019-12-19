package com.martak.adventofcode.intcodecomputer.model.argmode;

import com.martak.adventofcode.intcodecomputer.model.Context;

import java.math.BigInteger;

public interface ArgMode {

    BigInteger getValue(Context context, int pointer);

}
