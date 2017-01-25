package mil.army.usace.erdc.bcct.ta.model;

public class EstrogenicAEMVitro {

	  public boolean isSupervised() { return false; }
	  public int nfeatures() { return 10; }
	  public int nclasses() { return 10; }
	  // Thread-local storage for input neuron activation values.
	  final double[] NUMS = new double[10];
	  static class NORMMUL implements java.io.Serializable {
	    public static final double[] VALUES = new double[10];
	    static {
	      NORMMUL_0.fill(VALUES);
	    }
	    static class NORMMUL_0 implements java.io.Serializable {
	      static final void fill(double[] sa) {
	    	  sa[0] = 0.5030038443095983;
	          sa[1] = 0.5124187678516595;
	          sa[2] = 0.69865622605199;
	          sa[3] = 0.5245312063974193;
	          sa[4] = 0.5428709219729625;
	          sa[5] = 0.5287639673820141;
	          sa[6] = 0.5279497243265929;
	          sa[7] = 0.5406457582478045;
	          sa[8] = 0.6643518031370953;
	          sa[9] = 0.5187593372973975;
	      }
	    }
	}
	  static class NORMSUB implements java.io.Serializable {
	    public static final double[] VALUES = new double[10];
	    static {
	      NORMSUB_0.fill(VALUES);
	    }
	    static class NORMSUB_0 implements java.io.Serializable {
	      static final void fill(double[] sa) {
	    	  sa[0] = -0.19195999685476642;
	          sa[1] = -0.29266964659635614;
	          sa[2] = 0.36811529572661056;
	          sa[3] = 0.527697019238645;
	          sa[4] = 0.5583611165117952;
	          sa[5] = 0.38898700443805045;
	          sa[6] = 0.5943722806365754;
	          sa[7] = 0.4016287348964661;
	          sa[8] = 0.5597630926808597;
	          sa[9] = -0.18794574934109137;
	      }
	    }
	}
	  // Workspace for categorical offsets.
	  public static int[] CATOFFSETS = {0};
	  // Number of neurons for each layer.
	  public static int[] NEURONS = {10,10,2,10,10};
	    public int getPredsSize() { return 10; }
	    public boolean isAutoEncoder() { return true; }
	    public String getHeader() { return "reconstr_ATG_CIS,reconstr_ATG_TRANS,reconstr_NVS_NR_hER,reconstr_OT_ER_ERaERa_0480,reconstr_OT_ER_ERaERa_1440,reconstr_OT_ER_ERaERb_0480,reconstr_OT_ER_ERaERb_1440,reconstr_OT_ER_ERbERb_0480,reconstr_OT_ER_ERbERb_1440,reconstr_TOX21_ERa_BLA_Agonist"; }
	    // Thread-local storage for neuron activation values.
	    public double[][] ACTIVATION = new double[][] {
	      /* Input */ DeepLearning_model_R_1481832873762_1613_Activation_0.VALUES,
	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Activation_1.VALUES,
	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Activation_2.VALUES,
	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Activation_3.VALUES,
	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Activation_4.VALUES
	    };
	    // Neuron bias values.
	    public static double[][] BIAS = new double[][] {
	      /* Input */ DeepLearning_model_R_1481832873762_1613_Bias_0.VALUES,
	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Bias_1.VALUES,
	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Bias_2.VALUES,
	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Bias_3.VALUES,
	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Bias_4.VALUES
	    };
	    // Connecting weights between neurons.
	    public static float[][] WEIGHT = new float[][] {
	      /* Input */ DeepLearning_model_R_1481832873762_1613_Weight_0.VALUES,
	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Weight_1.VALUES,
	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Weight_2.VALUES,
	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Weight_3.VALUES,
	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Weight_4.VALUES
	    };

	  // Names of columns used by model.
	  public static final String[] NAMES = NamesHolder_DeepLearning_model_R_1481832873762_1613.VALUES;

	  // Column domains. The last array contains domain of response column.
	  public static final String[][] DOMAINS = new String[][] {
	    /* ATG_CIS */ null,
	    /* ATG_TRANS */ null,
	    /* NVS_NR_hER */ null,
	    /* OT_ER_ERaERa_0480 */ null,
	    /* OT_ER_ERaERa_1440 */ null,
	    /* OT_ER_ERaERb_0480 */ null,
	    /* OT_ER_ERaERb_1440 */ null,
	    /* OT_ER_ERbERb_0480 */ null,
	    /* OT_ER_ERbERb_1440 */ null,
	    /* TOX21_ERa_BLA_Agonist */ null
	  };

	  public String getUUID() { return Long.toString(5927150902475541984L); }

	  // Pass in data in a double[], pre-aligned to the Model's requirements.
	  // Jam predictions into the preds[] array; preds[0] is reserved for the
	  // main prediction (class for classifiers or value for regression),
	  // and remaining columns hold a probability distribution for classifiers.
	  public double[] score0( double[] data, double[] preds ) {
	    java.util.Arrays.fill(preds,0);
	    java.util.Arrays.fill(NUMS,0);
	    int i = 0, ncats = 0;
	    final int n = data.length;
	    for(; i<n; ++i) {
	      NUMS[i] = Double.isNaN(data[i]) ? 0 : (data[i] - NORMSUB.VALUES[i])*NORMMUL.VALUES[i];
	    }
	    java.util.Arrays.fill(ACTIVATION[0],0);
	    for (i=0; i<NUMS.length; ++i) {
	      ACTIVATION[0][CATOFFSETS[CATOFFSETS.length-1] + i] = Double.isNaN(NUMS[i]) ? 0 : NUMS[i];
	    }
	    for (i=1; i<ACTIVATION.length; ++i) {
	      java.util.Arrays.fill(ACTIVATION[i],0);
	      int cols = ACTIVATION[i-1].length;
	      int rows = ACTIVATION[i].length;
	      int extra=cols-cols%8;
	      int multiple = (cols/8)*8-1;
	      int idx = 0;
	      float[] a = WEIGHT[i];
	      double[] x = ACTIVATION[i-1];
	      double[] y = BIAS[i];
	      double[] res = ACTIVATION[i];
	      for (int row=0; row<rows; ++row) {
	        double psum0 = 0, psum1 = 0, psum2 = 0, psum3 = 0, psum4 = 0, psum5 = 0, psum6 = 0, psum7 = 0;
	        for (int col = 0; col < multiple; col += 8) {
	          int off = idx + col;
	          psum0 += a[off    ] * x[col    ];
	          psum1 += a[off + 1] * x[col + 1];
	          psum2 += a[off + 2] * x[col + 2];
	          psum3 += a[off + 3] * x[col + 3];
	          psum4 += a[off + 4] * x[col + 4];
	          psum5 += a[off + 5] * x[col + 5];
	          psum6 += a[off + 6] * x[col + 6];
	          psum7 += a[off + 7] * x[col + 7];
	        }
	        res[row] += psum0 + psum1 + psum2 + psum3;
	        res[row] += psum4 + psum5 + psum6 + psum7;
	        for (int col = extra; col < cols; col++)
	          res[row] += a[idx + col] * x[col];
	        res[row] += y[row];
	        idx += cols;
	      }
	      if (i<=ACTIVATION.length-1) {
	        for (int r=0; r<ACTIVATION[i].length; ++r) {
	          ACTIVATION[i][r] = 1 - 2 / (1 + Math.exp(2*ACTIVATION[i][r]));
	        }
	      }
	      if (i == ACTIVATION.length-1) {
	        for (int r=0; r<ACTIVATION[i].length; r++) {
	          if (Double.isNaN(ACTIVATION[i][r]))
	            throw new RuntimeException("Numerical instability, reconstructed NaN.");
	          preds[r] = ACTIVATION[i][r];
	        }
	        for (int k=0; k<10; ++k) {
	          preds[k] = preds[k] / NORMMUL.VALUES[k-0] + NORMSUB.VALUES[k-0];
	        }
	      }
	    }
	    return preds;
	  }
	}
	// Neuron activation values for Input layer
	class DeepLearning_model_R_1481832873762_1613_Activation_0 implements java.io.Serializable {
	  public static final double[] VALUES = new double[10];
	  static {
	    DeepLearning_model_R_1481832873762_1613_Activation_0_0.fill(VALUES);
	  }
	  static final class DeepLearning_model_R_1481832873762_1613_Activation_0_0 implements java.io.Serializable {
	    static final void fill(double[] sa) {
	      sa[0] = 0.0;
	      sa[1] = 0.0;
	      sa[2] = 0.0;
	      sa[3] = 0.0;
	      sa[4] = 0.0;
	      sa[5] = 0.0;
	      sa[6] = 0.0;
	      sa[7] = 0.0;
	      sa[8] = 0.0;
	      sa[9] = 0.0;
	    }
	  }
	}
	// Neuron activation values for Tanh layer
	class DeepLearning_model_R_1481832873762_1613_Activation_1 implements java.io.Serializable {
	  public static final double[] VALUES = new double[10];
	  static {
	    DeepLearning_model_R_1481832873762_1613_Activation_1_0.fill(VALUES);
	  }
	  static final class DeepLearning_model_R_1481832873762_1613_Activation_1_0 implements java.io.Serializable {
	    static final void fill(double[] sa) {
	      sa[0] = 0.0;
	      sa[1] = 0.0;
	      sa[2] = 0.0;
	      sa[3] = 0.0;
	      sa[4] = 0.0;
	      sa[5] = 0.0;
	      sa[6] = 0.0;
	      sa[7] = 0.0;
	      sa[8] = 0.0;
	      sa[9] = 0.0;
	    }
	  }
	}
	// Neuron activation values for Tanh layer
	class DeepLearning_model_R_1481832873762_1613_Activation_2 implements java.io.Serializable {
	  public static final double[] VALUES = new double[2];
	  static {
	    DeepLearning_model_R_1481832873762_1613_Activation_2_0.fill(VALUES);
	  }
	  static final class DeepLearning_model_R_1481832873762_1613_Activation_2_0 implements java.io.Serializable {
	    static final void fill(double[] sa) {
	      sa[0] = 0.0;
	      sa[1] = 0.0;
	    }
	  }
	}
	// Neuron activation values for Tanh layer
	class DeepLearning_model_R_1481832873762_1613_Activation_3 implements java.io.Serializable {
	  public static final double[] VALUES = new double[10];
	  static {
	    DeepLearning_model_R_1481832873762_1613_Activation_3_0.fill(VALUES);
	  }
	  static final class DeepLearning_model_R_1481832873762_1613_Activation_3_0 implements java.io.Serializable {
	    static final void fill(double[] sa) {
	      sa[0] = 0.0;
	      sa[1] = 0.0;
	      sa[2] = 0.0;
	      sa[3] = 0.0;
	      sa[4] = 0.0;
	      sa[5] = 0.0;
	      sa[6] = 0.0;
	      sa[7] = 0.0;
	      sa[8] = 0.0;
	      sa[9] = 0.0;
	    }
	  }
	}
	// Neuron activation values for Tanh layer
	class DeepLearning_model_R_1481832873762_1613_Activation_4 implements java.io.Serializable {
	  public static final double[] VALUES = new double[10];
	  static {
	    DeepLearning_model_R_1481832873762_1613_Activation_4_0.fill(VALUES);
	  }
	  static final class DeepLearning_model_R_1481832873762_1613_Activation_4_0 implements java.io.Serializable {
	    static final void fill(double[] sa) {
	      sa[0] = 0.0;
	      sa[1] = 0.0;
	      sa[2] = 0.0;
	      sa[3] = 0.0;
	      sa[4] = 0.0;
	      sa[5] = 0.0;
	      sa[6] = 0.0;
	      sa[7] = 0.0;
	      sa[8] = 0.0;
	      sa[9] = 0.0;
	    }
	  }
	}
	// Neuron bias values for Input layer
	class DeepLearning_model_R_1481832873762_1613_Bias_0 implements java.io.Serializable {
	  public static final double[] VALUES = null;
	}
	// Neuron bias values for Tanh layer
	class DeepLearning_model_R_1481832873762_1613_Bias_1 implements java.io.Serializable {
	  public static final double[] VALUES = new double[10];
	  static {
	    DeepLearning_model_R_1481832873762_1613_Bias_1_0.fill(VALUES);
	  }
	  static final class DeepLearning_model_R_1481832873762_1613_Bias_1_0 implements java.io.Serializable {
	    static final void fill(double[] sa) {
	    	sa[0] = -1.7226146711481014;
	        sa[1] = 1.2649074935661;
	        sa[2] = -0.3392463383981066;
	        sa[3] = -2.291310675923098;
	        sa[4] = -0.32873608103027885;
	        sa[5] = -1.661198907042371;
	        sa[6] = 1.0508377426366902;
	        sa[7] = -0.6951502320498835;
	        sa[8] = -0.29463569435150033;
	        sa[9] = -0.009650160726317438;
	    }
	  }
	}
	// Neuron bias values for Tanh layer
	class DeepLearning_model_R_1481832873762_1613_Bias_2 implements java.io.Serializable {
	  public static final double[] VALUES = new double[2];
	  static {
	    DeepLearning_model_R_1481832873762_1613_Bias_2_0.fill(VALUES);
	  }
	  static final class DeepLearning_model_R_1481832873762_1613_Bias_2_0 implements java.io.Serializable {
	    static final void fill(double[] sa) {
	    	sa[0] = -0.21697100775812456;
	        sa[1] = 0.2262888610574413;
	    }
	  }
	}
	// Neuron bias values for Tanh layer
	class DeepLearning_model_R_1481832873762_1613_Bias_3 implements java.io.Serializable {
	  public static final double[] VALUES = new double[10];
	  static {
	    DeepLearning_model_R_1481832873762_1613_Bias_3_0.fill(VALUES);
	  }
	  static final class DeepLearning_model_R_1481832873762_1613_Bias_3_0 implements java.io.Serializable {
	    static final void fill(double[] sa) {
	    	sa[0] = -0.38435234133081614;
	        sa[1] = 0.42506659781493805;
	        sa[2] = -1.0080341137822733;
	        sa[3] = -0.2548219133463463;
	        sa[4] = 0.005538784591892991;
	        sa[5] = 1.0268087574719775;
	        sa[6] = 0.56313863867996;
	        sa[7] = -2.097462452177422;
	        sa[8] = -0.04565760547278188;
	        sa[9] = -1.2370710325373786;
	    }
	  }
	}
	// Neuron bias values for Tanh layer
	class DeepLearning_model_R_1481832873762_1613_Bias_4 implements java.io.Serializable {
	  public static final double[] VALUES = new double[10];
	  static {
	    DeepLearning_model_R_1481832873762_1613_Bias_4_0.fill(VALUES);
	  }
	  static final class DeepLearning_model_R_1481832873762_1613_Bias_4_0 implements java.io.Serializable {
	    static final void fill(double[] sa) {
	    	sa[0] = 0.05909798670904463;
	        sa[1] = -0.28625129694505447;
	        sa[2] = -0.8593342713678475;
	        sa[3] = -0.33422218009540244;
	        sa[4] = -0.37172575117614026;
	        sa[5] = -0.8304719699765228;
	        sa[6] = -1.2487897723040817;
	        sa[7] = -0.5755084013715521;
	        sa[8] = -0.44551656451315236;
	        sa[9] = 1.2668929813518601;
	    }
	  }
	}
	class DeepLearning_model_R_1481832873762_1613_Weight_0 implements java.io.Serializable {
	  public static final float[] VALUES = null;
	}
	// Neuron weights connecting Input and Tanh layer
	class DeepLearning_model_R_1481832873762_1613_Weight_1 implements java.io.Serializable {
	  public static final float[] VALUES = new float[100];
	  static {
	    DeepLearning_model_R_1481832873762_1613_Weight_1_0.fill(VALUES);
	  }
	  static final class DeepLearning_model_R_1481832873762_1613_Weight_1_0 implements java.io.Serializable {
	    static final void fill(float[] sa) {
	    	sa[0] = -0.14372306f;
	        sa[1] = 1.0717508f;
	        sa[2] = 0.17513083f;
	        sa[3] = 0.9533972f;
	        sa[4] = -1.8291802f;
	        sa[5] = -0.2594465f;
	        sa[6] = -1.5463638f;
	        sa[7] = 0.8772057f;
	        sa[8] = -0.6555623f;
	        sa[9] = 1.5746514f;
	        sa[10] = -0.83819234f;
	        sa[11] = 0.11850269f;
	        sa[12] = 0.09164714f;
	        sa[13] = -0.49956262f;
	        sa[14] = 1.6621125f;
	        sa[15] = 0.39798275f;
	        sa[16] = 0.38897172f;
	        sa[17] = 0.3349022f;
	        sa[18] = 0.5748485f;
	        sa[19] = -0.36225766f;
	        sa[20] = -0.8736183f;
	        sa[21] = 0.20743097f;
	        sa[22] = 0.8491713f;
	        sa[23] = 0.6523762f;
	        sa[24] = -0.38447085f;
	        sa[25] = 0.12096879f;
	        sa[26] = -0.25391763f;
	        sa[27] = -0.021658253f;
	        sa[28] = -0.7011617f;
	        sa[29] = 0.30722466f;
	        sa[30] = -0.7149213f;
	        sa[31] = -1.5564169f;
	        sa[32] = -2.5198882f;
	        sa[33] = -0.23656948f;
	        sa[34] = 0.19185393f;
	        sa[35] = 1.1899189f;
	        sa[36] = -0.7039521f;
	        sa[37] = -1.1918285f;
	        sa[38] = -0.044882517f;
	        sa[39] = 0.33163786f;
	        sa[40] = -0.07057496f;
	        sa[41] = -1.5009866f;
	        sa[42] = -0.06553147f;
	        sa[43] = -0.017364098f;
	        sa[44] = 0.19240749f;
	        sa[45] = 0.76422346f;
	        sa[46] = -0.19721043f;
	        sa[47] = 0.18109968f;
	        sa[48] = -0.4286706f;
	        sa[49] = -0.6902032f;
	        sa[50] = -0.48544487f;
	        sa[51] = 0.14366505f;
	        sa[52] = 1.1345314f;
	        sa[53] = 1.3269155f;
	        sa[54] = 0.0685131f;
	        sa[55] = -0.5402718f;
	        sa[56] = -1.175762f;
	        sa[57] = 0.7084892f;
	        sa[58] = -0.2551828f;
	        sa[59] = 1.8953834f;
	        sa[60] = -0.19366318f;
	        sa[61] = -1.0069971f;
	        sa[62] = 0.5489782f;
	        sa[63] = 1.8761653f;
	        sa[64] = 0.2610459f;
	        sa[65] = 0.9366773f;
	        sa[66] = -1.7195648f;
	        sa[67] = 1.9803096f;
	        sa[68] = -0.3964773f;
	        sa[69] = -0.7089813f;
	        sa[70] = 0.9473746f;
	        sa[71] = 0.92076826f;
	        sa[72] = -0.014057732f;
	        sa[73] = 0.12641421f;
	        sa[74] = 1.0001912f;
	        sa[75] = 0.4323911f;
	        sa[76] = 0.9181664f;
	        sa[77] = 0.7515459f;
	        sa[78] = -0.43097794f;
	        sa[79] = -0.049254574f;
	        sa[80] = 0.11277276f;
	        sa[81] = -0.5040156f;
	        sa[82] = -0.43353754f;
	        sa[83] = -1.0178434f;
	        sa[84] = -0.32931086f;
	        sa[85] = -0.11612138f;
	        sa[86] = -0.44135028f;
	        sa[87] = 0.823344f;
	        sa[88] = 0.95395625f;
	        sa[89] = -0.4162948f;
	        sa[90] = -0.101326115f;
	        sa[91] = 0.22565381f;
	        sa[92] = -0.036652043f;
	        sa[93] = 0.2990938f;
	        sa[94] = 0.102422245f;
	        sa[95] = -0.007257694f;
	        sa[96] = -0.36080936f;
	        sa[97] = -0.17462097f;
	        sa[98] = 0.16745165f;
	        sa[99] = -0.7088857f;
	    }
	  }
	}
	// Neuron weights connecting Tanh and Tanh layer
	class DeepLearning_model_R_1481832873762_1613_Weight_2 implements java.io.Serializable {
	  public static final float[] VALUES = new float[20];
	  static {
	    DeepLearning_model_R_1481832873762_1613_Weight_2_0.fill(VALUES);
	  }
	  static final class DeepLearning_model_R_1481832873762_1613_Weight_2_0 implements java.io.Serializable {
	    static final void fill(float[] sa) {
	    	sa[0] = -1.0681777f;
	        sa[1] = -1.6739489f;
	        sa[2] = 0.59869593f;
	        sa[3] = 0.011004634f;
	        sa[4] = 0.2685249f;
	        sa[5] = -1.2732574f;
	        sa[6] = -1.2747256f;
	        sa[7] = -0.27706558f;
	        sa[8] = -0.49374107f;
	        sa[9] = 0.13270834f;
	        sa[10] = -1.2261603f;
	        sa[11] = 0.531498f;
	        sa[12] = -0.38000244f;
	        sa[13] = 1.4982828f;
	        sa[14] = -0.359492f;
	        sa[15] = 0.87773395f;
	        sa[16] = 0.48362732f;
	        sa[17] = -0.6051587f;
	        sa[18] = -0.013676618f;
	        sa[19] = 0.10977546f;
	    }
	  }
	}
	// Neuron weights connecting Tanh and Tanh layer
	class DeepLearning_model_R_1481832873762_1613_Weight_3 implements java.io.Serializable {
	  public static final float[] VALUES = new float[20];
	  static {
	    DeepLearning_model_R_1481832873762_1613_Weight_3_0.fill(VALUES);
	  }
	  static final class DeepLearning_model_R_1481832873762_1613_Weight_3_0 implements java.io.Serializable {
	    static final void fill(float[] sa) {
	    	sa[0] = 0.9585431f;
	        sa[1] = -0.5148299f;
	        sa[2] = -2.5234206f;
	        sa[3] = 1.5241615f;
	        sa[4] = 0.4889856f;
	        sa[5] = 4.3231835f;
	        sa[6] = 0.72345215f;
	        sa[7] = 2.8521664f;
	        sa[8] = -1.520968f;
	        sa[9] = 0.35253906f;
	        sa[10] = 0.20348696f;
	        sa[11] = 1.4169936f;
	        sa[12] = -1.1692357f;
	        sa[13] = -0.87090904f;
	        sa[14] = -2.6541438f;
	        sa[15] = -1.30751f;
	        sa[16] = -2.3575451f;
	        sa[17] = -0.63371104f;
	        sa[18] = 1.7900845f;
	        sa[19] = -3.6685486f;
	    }
	  }
	}
	// Neuron weights connecting Tanh and Tanh layer
	class DeepLearning_model_R_1481832873762_1613_Weight_4 implements java.io.Serializable {
	  public static final float[] VALUES = new float[100];
	  static {
	    DeepLearning_model_R_1481832873762_1613_Weight_4_0.fill(VALUES);
	  }
	  static final class DeepLearning_model_R_1481832873762_1613_Weight_4_0 implements java.io.Serializable {
	    static final void fill(float[] sa) {
	    	sa[0] = 0.44896019f;
	        sa[1] = -0.1822768f;
	        sa[2] = -0.57286024f;
	        sa[3] = -0.072267264f;
	        sa[4] = 0.79136014f;
	        sa[5] = 0.5641429f;
	        sa[6] = -0.309636f;
	        sa[7] = 0.17398915f;
	        sa[8] = -0.3001971f;
	        sa[9] = -0.058354944f;
	        sa[10] = -0.6837318f;
	        sa[11] = -0.26653472f;
	        sa[12] = 0.5999647f;
	        sa[13] = -0.7197694f;
	        sa[14] = -0.06740475f;
	        sa[15] = 1.4958111f;
	        sa[16] = 0.8806275f;
	        sa[17] = 0.90002877f;
	        sa[18] = -0.7422029f;
	        sa[19] = 0.77738506f;
	        sa[20] = 1.1919434f;
	        sa[21] = 1.6026299f;
	        sa[22] = -0.40695655f;
	        sa[23] = 0.69635296f;
	        sa[24] = -2.444905f;
	        sa[25] = 0.6380789f;
	        sa[26] = 2.090631f;
	        sa[27] = 0.45437545f;
	        sa[28] = 0.25096133f;
	        sa[29] = -0.31017554f;
	        sa[30] = -0.85357577f;
	        sa[31] = -0.8895473f;
	        sa[32] = 0.65574676f;
	        sa[33] = -1.1411767f;
	        sa[34] = 0.6622708f;
	        sa[35] = -0.38863772f;
	        sa[36] = -0.13928933f;
	        sa[37] = -0.37097454f;
	        sa[38] = -0.2417794f;
	        sa[39] = -0.7473462f;
	        sa[40] = 1.2174269f;
	        sa[41] = 0.19677335f;
	        sa[42] = 0.7672264f;
	        sa[43] = -0.94374067f;
	        sa[44] = 0.53019154f;
	        sa[45] = 1.324766f;
	        sa[46] = 0.101495944f;
	        sa[47] = 0.26474693f;
	        sa[48] = -0.11462032f;
	        sa[49] = 0.01959631f;
	        sa[50] = -0.6559893f;
	        sa[51] = 0.76616067f;
	        sa[52] = 0.019847743f;
	        sa[53] = -0.36349514f;
	        sa[54] = -1.2668405f;
	        sa[55] = 1.1019541f;
	        sa[56] = -0.22701433f;
	        sa[57] = -0.07938862f;
	        sa[58] = 0.7166818f;
	        sa[59] = 0.5220358f;
	        sa[60] = -0.028002826f;
	        sa[61] = -0.056346573f;
	        sa[62] = 0.1021374f;
	        sa[63] = -0.5056765f;
	        sa[64] = -0.15451439f;
	        sa[65] = 1.7599941f;
	        sa[66] = -0.10987537f;
	        sa[67] = -0.076525226f;
	        sa[68] = 0.24763937f;
	        sa[69] = -0.0029320507f;
	        sa[70] = -0.40886465f;
	        sa[71] = -0.71930677f;
	        sa[72] = 0.17030944f;
	        sa[73] = -0.6285189f;
	        sa[74] = 0.012403147f;
	        sa[75] = -0.013362185f;
	        sa[76] = -0.22136144f;
	        sa[77] = -0.3868219f;
	        sa[78] = 0.5238513f;
	        sa[79] = -0.86391395f;
	        sa[80] = 0.2494043f;
	        sa[81] = 0.04188248f;
	        sa[82] = 0.1824032f;
	        sa[83] = -0.19524387f;
	        sa[84] = 0.09248167f;
	        sa[85] = 0.5597933f;
	        sa[86] = 0.3264913f;
	        sa[87] = 0.1800613f;
	        sa[88] = -0.19812363f;
	        sa[89] = -0.25073743f;
	        sa[90] = 0.47341502f;
	        sa[91] = -1.2917309f;
	        sa[92] = 2.3898606f;
	        sa[93] = -2.11731f;
	        sa[94] = -0.32122517f;
	        sa[95] = 0.32991487f;
	        sa[96] = 0.2579796f;
	        sa[97] = 1.488695f;
	        sa[98] = 0.15953025f;
	        sa[99] = -0.8762168f;
	    }
	  }
	}
	// The class representing training column names
	class NamesHolder_DeepLearning_model_R_1481832873762_1613 implements java.io.Serializable {
	  public static final String[] VALUES = new String[10];
	  static {
	    NamesHolder_DeepLearning_model_R_1481832873762_1613_0.fill(VALUES);
	  }
	  static final class NamesHolder_DeepLearning_model_R_1481832873762_1613_0 implements java.io.Serializable {
	    static final void fill(String[] sa) {
	      sa[0] = "ATG_CIS";
	      sa[1] = "ATG_TRANS";
	      sa[2] = "NVS_NR_hER";
	      sa[3] = "OT_ER_ERaERa_0480";
	      sa[4] = "OT_ER_ERaERa_1440";
	      sa[5] = "OT_ER_ERaERb_0480";
	      sa[6] = "OT_ER_ERaERb_1440";
	      sa[7] = "OT_ER_ERbERb_0480";
	      sa[8] = "OT_ER_ERbERb_1440";
	      sa[9] = "TOX21_ERa_BLA_Agonist";
	    }
	  }
	}


