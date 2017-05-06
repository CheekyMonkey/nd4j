package org.nd4j.linalg.learning.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.learning.AdaDeltaUpdater;
import org.nd4j.linalg.learning.GradientUpdater;

/**
 * Created by Alex on 06/05/2017.
 */
@Data
@AllArgsConstructor
@Builder
public class AdaDelta implements IUpdater {
    public static final double DEFAULT_ADADELTA_EPSILON = 1e-6;
    public static final double DEFAULT_ADADELTA_RHO = 0.95;

    private double rho;
    private double epsilon;

    public AdaDelta(){
        this(DEFAULT_ADADELTA_RHO, DEFAULT_ADADELTA_EPSILON);
    }

    @Override
    public long stateSize(long numParams) {
        return 2 * numParams;
    }

    @Override
    public void applySchedules(int iteration, double newLearningRate) {
        //No op - AdaDelta doesn't use LR
    }

    @Override
    public GradientUpdater instantiate(INDArray viewArray, boolean initializeViewArray) {
        AdaDeltaUpdater u = new AdaDeltaUpdater(this);

        return null;
    }

    @Override
    public AdaDelta clone() {
        return new AdaDelta(rho, epsilon);
    }
}
