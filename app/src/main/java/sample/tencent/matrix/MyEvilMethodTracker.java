package sample.tencent.matrix;

import static sample.tencent.matrix.MatrixApplication.IS_TRACE_ENABLE;

import android.util.Log;

import com.tencent.matrix.trace.config.TraceConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.tracer.EvilMethodTracer;

public class MyEvilMethodTracker extends EvilMethodTracer {

    public MyEvilMethodTracker(TraceConfig config) {
        super(config);
    }

    @Override
    public void onDispatchBegin(String log) {
        Log.i("Zyp", "onDispatchBegin");
        super.onDispatchBegin(log);
        if (IS_TRACE_ENABLE) {
            AppMethodBeat.i(AppMethodBeat.METHOD_ID_DISPATCH);

        }
    }

    @Override
    public void onDispatchEnd(String log, long beginNs, long endNs) {
        Log.i("Zyp", "onDispatchEnd");
        if (IS_TRACE_ENABLE) {

            AppMethodBeat.o(AppMethodBeat.METHOD_ID_DISPATCH);
        }
        super.onDispatchEnd(log, beginNs, endNs);

    }

}

