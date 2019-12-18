package com.martak.adventofcode.intcodecomputer.model.argmode;

import com.martak.adventofcode.intcodecomputer.model.Context;

public interface ArgMode {

    int getValue(Context context, int pointer);

}
