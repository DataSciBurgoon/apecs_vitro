//package mil.army.usace.erdc.bcct.ta.model;
//
//public class EstrogenicAEMVitro2 {
//
//	  public boolean isSupervised() { return false; }
//	  public int nfeatures() { return 10; }
//	  public int nclasses() { return 10; }
//	  // Thread-local storage for input neuron activation values.
//	  final double[] NUMS = new double[10];
//	  static class NORMMUL implements java.io.Serializable {
//	    public static final double[] VALUES = new double[10];
//	    static {
//	      NORMMUL_0.fill(VALUES);
//	    }
//	    static class NORMMUL_0 implements java.io.Serializable {
//	      static final void fill(double[] sa) {
//	    	  sa[0] = 0.5030038443078083;
//	          sa[1] = 0.5124187678136563;
//	          sa[2] = 0.6986562259909461;
//	          sa[3] = 0.5245312063592409;
//	          sa[4] = 0.5428709219581469;
//	          sa[5] = 0.5287639673642854;
//	          sa[6] = 0.5279497243249365;
//	          sa[7] = 0.5406457582583075;
//	          sa[8] = 0.6643518031439427;
//	          sa[9] = 0.5187593373004541;
//	      }
//	    }
//	}
//	  static class NORMSUB implements java.io.Serializable {
//	    public static final double[] VALUES = new double[10];
//	    static {
//	      NORMSUB_0.fill(VALUES);
//	    }
//	    static class NORMSUB_0 implements java.io.Serializable {
//	      static final void fill(double[] sa) {
//	    	  sa[0] = -0.19195999679699666;
//	          sa[1] = -0.29266964670788986;
//	          sa[2] = 0.3681152957399937;
//	          sa[3] = 0.5276970192212284;
//	          sa[4] = 0.5583611165666056;
//	          sa[5] = 0.38898700445554135;
//	          sa[6] = 0.5943722806466576;
//	          sa[7] = 0.4016287348760746;
//	          sa[8] = 0.5597630926649363;
//	          sa[9] = -0.1879457493618935;
//	      }
//	    }
//	}
//	  // Workspace for categorical offsets.
//	  public static int[] CATOFFSETS = {0};
//	  // Number of neurons for each layer.
//	  public static int[] NEURONS = {10,10,2,10,10};
//	    public int getPredsSize() { return 10; }
//	    public boolean isAutoEncoder() { return true; }
//	    public String getHeader() { return "reconstr_ATG_CIS,reconstr_ATG_TRANS,reconstr_NVS_NR_hER,reconstr_OT_ER_ERaERa_0480,reconstr_OT_ER_ERaERa_1440,reconstr_OT_ER_ERaERb_0480,reconstr_OT_ER_ERaERb_1440,reconstr_OT_ER_ERbERb_0480,reconstr_OT_ER_ERbERb_1440,reconstr_TOX21_ERa_BLA_Agonist"; }
//	    // Thread-local storage for neuron activation values.
//	    public double[][] ACTIVATION = new double[][] {
//	      /* Input */ DeepLearning_model_R_1481832873762_1613_Activation_0.VALUES,
//	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Activation_1.VALUES,
//	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Activation_2.VALUES,
//	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Activation_3.VALUES,
//	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Activation_4.VALUES
//	    };
//	    // Neuron bias values.
//	    public static double[][] BIAS = new double[][] {
//	      /* Input */ DeepLearning_model_R_1481832873762_1613_Bias_0.VALUES,
//	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Bias_1.VALUES,
//	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Bias_2.VALUES,
//	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Bias_3.VALUES,
//	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Bias_4.VALUES
//	    };
//	    // Connecting weights between neurons.
//	    public static float[][] WEIGHT = new float[][] {
//	      /* Input */ DeepLearning_model_R_1481832873762_1613_Weight_0.VALUES,
//	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Weight_1.VALUES,
//	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Weight_2.VALUES,
//	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Weight_3.VALUES,
//	      /* Tanh */ DeepLearning_model_R_1481832873762_1613_Weight_4.VALUES
//	    };
//
//	  // Names of columns used by model.
//	  public static final String[] NAMES = NamesHolder_DeepLearning_model_R_1481832873762_1613.VALUES;
//
//	  // Column domains. The last array contains domain of response column.
//	  public static final String[][] DOMAINS = new String[][] {
//	    /* ATG_CIS */ null,
//	    /* ATG_TRANS */ null,
//	    /* NVS_NR_hER */ null,
//	    /* OT_ER_ERaERa_0480 */ null,
//	    /* OT_ER_ERaERa_1440 */ null,
//	    /* OT_ER_ERaERb_0480 */ null,
//	    /* OT_ER_ERaERb_1440 */ null,
//	    /* OT_ER_ERbERb_0480 */ null,
//	    /* OT_ER_ERbERb_1440 */ null,
//	    /* TOX21_ERa_BLA_Agonist */ null
//	  };
//
//	  public String getUUID() { return Long.toString(5927150902475541984L); }
//
//	  // Pass in data in a double[], pre-aligned to the Model's requirements.
//	  // Jam predictions into the preds[] array; preds[0] is reserved for the
//	  // main prediction (class for classifiers or value for regression),
//	  // and remaining columns hold a probability distribution for classifiers.
//	  public double[] score0( double[] data, double[] preds ) {
//	    java.util.Arrays.fill(preds,0);
//	    java.util.Arrays.fill(NUMS,0);
//	    int i = 0, ncats = 0;
//	    final int n = data.length;
//	    for(; i<n; ++i) {
//	      NUMS[i] = Double.isNaN(data[i]) ? 0 : (data[i] - NORMSUB.VALUES[i])*NORMMUL.VALUES[i];
//	    }
//	    java.util.Arrays.fill(ACTIVATION[0],0);
//	    for (i=0; i<NUMS.length; ++i) {
//	      ACTIVATION[0][CATOFFSETS[CATOFFSETS.length-1] + i] = Double.isNaN(NUMS[i]) ? 0 : NUMS[i];
//	    }
//	    for (i=1; i<ACTIVATION.length; ++i) {
//	      java.util.Arrays.fill(ACTIVATION[i],0);
//	      int cols = ACTIVATION[i-1].length;
//	      int rows = ACTIVATION[i].length;
//	      int extra=cols-cols%8;
//	      int multiple = (cols/8)*8-1;
//	      int idx = 0;
//	      float[] a = WEIGHT[i];
//	      double[] x = ACTIVATION[i-1];
//	      double[] y = BIAS[i];
//	      double[] res = ACTIVATION[i];
//	      for (int row=0; row<rows; ++row) {
//	        double psum0 = 0, psum1 = 0, psum2 = 0, psum3 = 0, psum4 = 0, psum5 = 0, psum6 = 0, psum7 = 0;
//	        for (int col = 0; col < multiple; col += 8) {
//	          int off = idx + col;
//	          psum0 += a[off    ] * x[col    ];
//	          psum1 += a[off + 1] * x[col + 1];
//	          psum2 += a[off + 2] * x[col + 2];
//	          psum3 += a[off + 3] * x[col + 3];
//	          psum4 += a[off + 4] * x[col + 4];
//	          psum5 += a[off + 5] * x[col + 5];
//	          psum6 += a[off + 6] * x[col + 6];
//	          psum7 += a[off + 7] * x[col + 7];
//	        }
//	        res[row] += psum0 + psum1 + psum2 + psum3;
//	        res[row] += psum4 + psum5 + psum6 + psum7;
//	        for (int col = extra; col < cols; col++)
//	          res[row] += a[idx + col] * x[col];
//	        res[row] += y[row];
//	        idx += cols;
//	      }
//	      if (i<=ACTIVATION.length-1) {
//	        for (int r=0; r<ACTIVATION[i].length; ++r) {
//	          ACTIVATION[i][r] = 1 - 2 / (1 + Math.exp(2*ACTIVATION[i][r]));
//	        }
//	      }
//	      if (i == ACTIVATION.length-1) {
//	        for (int r=0; r<ACTIVATION[i].length; r++) {
//	          if (Double.isNaN(ACTIVATION[i][r]))
//	            throw new RuntimeException("Numerical instability, reconstructed NaN.");
//	          preds[r] = ACTIVATION[i][r];
//	        }
//	        for (int k=0; k<10; ++k) {
//	          preds[k] = preds[k] / NORMMUL.VALUES[k-0] + NORMSUB.VALUES[k-0];
//	        }
//	      }
//	    }
//	    return preds;
//	  }
//	}
//	// Neuron activation values for Input layer
//	class DeepLearning_model_R_1481832873762_1613_Activation_0 implements java.io.Serializable {
//	  public static final double[] VALUES = new double[10];
//	  static {
//	    DeepLearning_model_R_1481832873762_1613_Activation_0_0.fill(VALUES);
//	  }
//	  static final class DeepLearning_model_R_1481832873762_1613_Activation_0_0 implements java.io.Serializable {
//	    static final void fill(double[] sa) {
//	      sa[0] = 0.0;
//	      sa[1] = 0.0;
//	      sa[2] = 0.0;
//	      sa[3] = 0.0;
//	      sa[4] = 0.0;
//	      sa[5] = 0.0;
//	      sa[6] = 0.0;
//	      sa[7] = 0.0;
//	      sa[8] = 0.0;
//	      sa[9] = 0.0;
//	    }
//	  }
//	}
//	// Neuron activation values for Tanh layer
//	class DeepLearning_model_R_1481832873762_1613_Activation_1 implements java.io.Serializable {
//	  public static final double[] VALUES = new double[10];
//	  static {
//	    DeepLearning_model_R_1481832873762_1613_Activation_1_0.fill(VALUES);
//	  }
//	  static final class DeepLearning_model_R_1481832873762_1613_Activation_1_0 implements java.io.Serializable {
//	    static final void fill(double[] sa) {
//	      sa[0] = 0.0;
//	      sa[1] = 0.0;
//	      sa[2] = 0.0;
//	      sa[3] = 0.0;
//	      sa[4] = 0.0;
//	      sa[5] = 0.0;
//	      sa[6] = 0.0;
//	      sa[7] = 0.0;
//	      sa[8] = 0.0;
//	      sa[9] = 0.0;
//	    }
//	  }
//	}
//	// Neuron activation values for Tanh layer
//	class DeepLearning_model_R_1481832873762_1613_Activation_2 implements java.io.Serializable {
//	  public static final double[] VALUES = new double[2];
//	  static {
//	    DeepLearning_model_R_1481832873762_1613_Activation_2_0.fill(VALUES);
//	  }
//	  static final class DeepLearning_model_R_1481832873762_1613_Activation_2_0 implements java.io.Serializable {
//	    static final void fill(double[] sa) {
//	      sa[0] = 0.0;
//	      sa[1] = 0.0;
//	    }
//	  }
//	}
//	// Neuron activation values for Tanh layer
//	class DeepLearning_model_R_1481832873762_1613_Activation_3 implements java.io.Serializable {
//	  public static final double[] VALUES = new double[10];
//	  static {
//	    DeepLearning_model_R_1481832873762_1613_Activation_3_0.fill(VALUES);
//	  }
//	  static final class DeepLearning_model_R_1481832873762_1613_Activation_3_0 implements java.io.Serializable {
//	    static final void fill(double[] sa) {
//	      sa[0] = 0.0;
//	      sa[1] = 0.0;
//	      sa[2] = 0.0;
//	      sa[3] = 0.0;
//	      sa[4] = 0.0;
//	      sa[5] = 0.0;
//	      sa[6] = 0.0;
//	      sa[7] = 0.0;
//	      sa[8] = 0.0;
//	      sa[9] = 0.0;
//	    }
//	  }
//	}
//	// Neuron activation values for Tanh layer
//	class DeepLearning_model_R_1481832873762_1613_Activation_4 implements java.io.Serializable {
//	  public static final double[] VALUES = new double[10];
//	  static {
//	    DeepLearning_model_R_1481832873762_1613_Activation_4_0.fill(VALUES);
//	  }
//	  static final class DeepLearning_model_R_1481832873762_1613_Activation_4_0 implements java.io.Serializable {
//	    static final void fill(double[] sa) {
//	      sa[0] = 0.0;
//	      sa[1] = 0.0;
//	      sa[2] = 0.0;
//	      sa[3] = 0.0;
//	      sa[4] = 0.0;
//	      sa[5] = 0.0;
//	      sa[6] = 0.0;
//	      sa[7] = 0.0;
//	      sa[8] = 0.0;
//	      sa[9] = 0.0;
//	    }
//	  }
//	}
//	// Neuron bias values for Input layer
//	class DeepLearning_model_R_1481832873762_1613_Bias_0 implements java.io.Serializable {
//	  public static final double[] VALUES = null;
//	}
//	// Neuron bias values for Tanh layer
//	class DeepLearning_model_R_1481832873762_1613_Bias_1 implements java.io.Serializable {
//	  public static final double[] VALUES = new double[10];
//	  static {
//	    DeepLearning_model_R_1481832873762_1613_Bias_1_0.fill(VALUES);
//	  }
//	  static final class DeepLearning_model_R_1481832873762_1613_Bias_1_0 implements java.io.Serializable {
//	    static final void fill(double[] sa) {
//	    	sa[0] = -0.835799723860058;
//	        sa[1] = -0.5824860549902378;
//	        sa[2] = -0.4319622532703477;
//	        sa[3] = -0.3927118034582554;
//	        sa[4] = 2.115397843726288;
//	        sa[5] = -0.8594326521324844;
//	        sa[6] = 2.698946767493733;
//	        sa[7] = 0.6726429947966531;
//	        sa[8] = -1.9696911471749796;
//	        sa[9] = -1.7977719573998914;
//	    }
//	  }
//	}
//	// Neuron bias values for Tanh layer
//	class DeepLearning_model_R_1481832873762_1613_Bias_2 implements java.io.Serializable {
//	  public static final double[] VALUES = new double[2];
//	  static {
//	    DeepLearning_model_R_1481832873762_1613_Bias_2_0.fill(VALUES);
//	  }
//	  static final class DeepLearning_model_R_1481832873762_1613_Bias_2_0 implements java.io.Serializable {
//	    static final void fill(double[] sa) {
//	    	sa[0] = 0.1361464294634375;
//	        sa[1] = 0.5472664712554232;
//	    }
//	  }
//	}
//	// Neuron bias values for Tanh layer
//	class DeepLearning_model_R_1481832873762_1613_Bias_3 implements java.io.Serializable {
//	  public static final double[] VALUES = new double[10];
//	  static {
//	    DeepLearning_model_R_1481832873762_1613_Bias_3_0.fill(VALUES);
//	  }
//	  static final class DeepLearning_model_R_1481832873762_1613_Bias_3_0 implements java.io.Serializable {
//	    static final void fill(double[] sa) {
//	    	sa[0] = 0.714642886096879;
//	        sa[1] = 0.6863908327255963;
//	        sa[2] = -0.09533209668325589;
//	        sa[3] = -1.3398337922737482;
//	        sa[4] = 0.17962376359120047;
//	        sa[5] = -1.027398365391076;
//	        sa[6] = 0.8971575253680844;
//	        sa[7] = -2.1186933848077425;
//	        sa[8] = 0.7197797792608709;
//	        sa[9] = 1.5991249555782265;
//	    }
//	  }
//	}
//	// Neuron bias values for Tanh layer
//	class DeepLearning_model_R_1481832873762_1613_Bias_4 implements java.io.Serializable {
//	  public static final double[] VALUES = new double[10];
//	  static {
//	    DeepLearning_model_R_1481832873762_1613_Bias_4_0.fill(VALUES);
//	  }
//	  static final class DeepLearning_model_R_1481832873762_1613_Bias_4_0 implements java.io.Serializable {
//	    static final void fill(double[] sa) {
//	    	sa[0] = 0.5258111873480896;
//	        sa[1] = 0.6259790963160744;
//	        sa[2] = -0.36420835408240915;
//	        sa[3] = 0.6016673713043073;
//	        sa[4] = 0.40234550296058785;
//	        sa[5] = -0.7477861600915834;
//	        sa[6] = -1.3226049959578665;
//	        sa[7] = -0.12926069327629275;
//	        sa[8] = 0.19851900308135073;
//	        sa[9] = 0.20149354043346962;
//	    }
//	  }
//	}
//	class DeepLearning_model_R_1481832873762_1613_Weight_0 implements java.io.Serializable {
//	  public static final float[] VALUES = null;
//	}
//	// Neuron weights connecting Input and Tanh layer
//	class DeepLearning_model_R_1481832873762_1613_Weight_1 implements java.io.Serializable {
//	  public static final float[] VALUES = new float[100];
//	  static {
//	    DeepLearning_model_R_1481832873762_1613_Weight_1_0.fill(VALUES);
//	  }
//	  static final class DeepLearning_model_R_1481832873762_1613_Weight_1_0 implements java.io.Serializable {
//	    static final void fill(float[] sa) {
//	    	sa[0] = 0.21058509f;
//	        sa[1] = 0.2553081f;
//	        sa[2] = -1.1009785f;
//	        sa[3] = 0.04682131f;
//	        sa[4] = -0.60487145f;
//	        sa[5] = -0.4809117f;
//	        sa[6] = -1.4316313f;
//	        sa[7] = -1.1282055f;
//	        sa[8] = 0.09271933f;
//	        sa[9] = 0.3060758f;
//	        sa[10] = -0.09935774f;
//	        sa[11] = 0.6271264f;
//	        sa[12] = 0.3908317f;
//	        sa[13] = -0.25447085f;
//	        sa[14] = 0.8329881f;
//	        sa[15] = 1.505829f;
//	        sa[16] = 1.1899964f;
//	        sa[17] = 1.0801067f;
//	        sa[18] = -0.5386854f;
//	        sa[19] = -0.76085234f;
//	        sa[20] = -0.09479218f;
//	        sa[21] = -0.6065184f;
//	        sa[22] = 0.5133941f;
//	        sa[23] = 0.1550954f;
//	        sa[24] = -0.5492839f;
//	        sa[25] = -2.6379517E-4f;
//	        sa[26] = -0.3694791f;
//	        sa[27] = -0.56741136f;
//	        sa[28] = 0.1193225f;
//	        sa[29] = -0.21050878f;
//	        sa[30] = 1.0042145f;
//	        sa[31] = 0.52936614f;
//	        sa[32] = -0.86011094f;
//	        sa[33] = -0.98808724f;
//	        sa[34] = -0.16520473f;
//	        sa[35] = -1.1717169f;
//	        sa[36] = 1.0329207f;
//	        sa[37] = -1.0080941f;
//	        sa[38] = -1.3837419f;
//	        sa[39] = -0.28105432f;
//	        sa[40] = 1.3480604f;
//	        sa[41] = -0.1827866f;
//	        sa[42] = 2.1995955f;
//	        sa[43] = 0.04983915f;
//	        sa[44] = 0.32856917f;
//	        sa[45] = 0.094008245f;
//	        sa[46] = 1.1166165f;
//	        sa[47] = 0.6050834f;
//	        sa[48] = 0.4402362f;
//	        sa[49] = 0.88674664f;
//	        sa[50] = -0.28909197f;
//	        sa[51] = -0.34185544f;
//	        sa[52] = -0.5029674f;
//	        sa[53] = 0.41740057f;
//	        sa[54] = -0.118194856f;
//	        sa[55] = -0.12465405f;
//	        sa[56] = -0.29719028f;
//	        sa[57] = -1.1648935f;
//	        sa[58] = -0.23405492f;
//	        sa[59] = -0.30853713f;
//	        sa[60] = -0.0630862f;
//	        sa[61] = 0.9292052f;
//	        sa[62] = 1.8619812f;
//	        sa[63] = 1.5623403f;
//	        sa[64] = 0.11559469f;
//	        sa[65] = 0.96765786f;
//	        sa[66] = -0.3781806f;
//	        sa[67] = 0.43754295f;
//	        sa[68] = 1.5481994f;
//	        sa[69] = 1.3240871f;
//	        sa[70] = 0.7028754f;
//	        sa[71] = 0.31219754f;
//	        sa[72] = 1.0495167f;
//	        sa[73] = -0.6611769f;
//	        sa[74] = -0.1798778f;
//	        sa[75] = 0.4739577f;
//	        sa[76] = 0.7654075f;
//	        sa[77] = -0.16148534f;
//	        sa[78] = 0.40117186f;
//	        sa[79] = -0.9828252f;
//	        sa[80] = 0.99844414f;
//	        sa[81] = 0.29641795f;
//	        sa[82] = -1.6092392f;
//	        sa[83] = -1.9133633f;
//	        sa[84] = 0.4497354f;
//	        sa[85] = -0.7815872f;
//	        sa[86] = 0.70238644f;
//	        sa[87] = -2.0565078f;
//	        sa[88] = -0.10525363f;
//	        sa[89] = 0.6161634f;
//	        sa[90] = 1.0838954f;
//	        sa[91] = 0.56239563f;
//	        sa[92] = -0.35208896f;
//	        sa[93] = -0.3756265f;
//	        sa[94] = -0.19108973f;
//	        sa[95] = 0.518871f;
//	        sa[96] = -0.84751546f;
//	        sa[97] = 0.34838912f;
//	        sa[98] = -0.26867846f;
//	        sa[99] = 0.3441346f;
//	    }
//	  }
//	}
//	// Neuron weights connecting Tanh and Tanh layer
//	class DeepLearning_model_R_1481832873762_1613_Weight_2 implements java.io.Serializable {
//	  public static final float[] VALUES = new float[20];
//	  static {
//	    DeepLearning_model_R_1481832873762_1613_Weight_2_0.fill(VALUES);
//	  }
//	  static final class DeepLearning_model_R_1481832873762_1613_Weight_2_0 implements java.io.Serializable {
//	    static final void fill(float[] sa) {
//	    	sa[0] = -1.0076196f;
//	        sa[1] = 0.46718752f;
//	        sa[2] = 0.44005147f;
//	        sa[3] = 0.6687629f;
//	        sa[4] = 0.5559006f;
//	        sa[5] = 1.0551106f;
//	        sa[6] = -0.28514907f;
//	        sa[7] = -0.57880867f;
//	        sa[8] = 1.0514574f;
//	        sa[9] = -1.3921044f;
//	        sa[10] = -1.0033563f;
//	        sa[11] = -0.9242479f;
//	        sa[12] = -0.94807035f;
//	        sa[13] = -0.7858933f;
//	        sa[14] = -1.0011086f;
//	        sa[15] = -0.9345654f;
//	        sa[16] = -1.3323125f;
//	        sa[17] = -0.0051106378f;
//	        sa[18] = 0.35127237f;
//	        sa[19] = -0.35327107f;
//	    }
//	  }
//	}
//	// Neuron weights connecting Tanh and Tanh layer
//	class DeepLearning_model_R_1481832873762_1613_Weight_3 implements java.io.Serializable {
//	  public static final float[] VALUES = new float[20];
//	  static {
//	    DeepLearning_model_R_1481832873762_1613_Weight_3_0.fill(VALUES);
//	  }
//	  static final class DeepLearning_model_R_1481832873762_1613_Weight_3_0 implements java.io.Serializable {
//	    static final void fill(float[] sa) {
//	    	sa[0] = -1.4426494f;
//	        sa[1] = -1.0263995f;
//	        sa[2] = -2.930823f;
//	        sa[3] = -2.7444067f;
//	        sa[4] = 1.5695457f;
//	        sa[5] = 1.2788563f;
//	        sa[6] = 0.8092455f;
//	        sa[7] = -0.6628648f;
//	        sa[8] = -2.8146484f;
//	        sa[9] = 2.1618648f;
//	        sa[10] = 3.128707f;
//	        sa[11] = 0.091283955f;
//	        sa[12] = 0.18574178f;
//	        sa[13] = 1.4964504f;
//	        sa[14] = -0.8776937f;
//	        sa[15] = -2.603297f;
//	        sa[16] = -1.5094942f;
//	        sa[17] = 0.215126f;
//	        sa[18] = 2.3023636f;
//	        sa[19] = -0.25263283f;
//	    }
//	  }
//	}
//	// Neuron weights connecting Tanh and Tanh layer
//	class DeepLearning_model_R_1481832873762_1613_Weight_4 implements java.io.Serializable {
//	  public static final float[] VALUES = new float[100];
//	  static {
//	    DeepLearning_model_R_1481832873762_1613_Weight_4_0.fill(VALUES);
//	  }
//	  static final class DeepLearning_model_R_1481832873762_1613_Weight_4_0 implements java.io.Serializable {
//	    static final void fill(float[] sa) {
//	    	sa[0] = -1.4675232f;
//	        sa[1] = 0.9153019f;
//	        sa[2] = -0.47764766f;
//	        sa[3] = 0.29709715f;
//	        sa[4] = 0.06570314f;
//	        sa[5] = 0.22718999f;
//	        sa[6] = -0.3998043f;
//	        sa[7] = -0.91330695f;
//	        sa[8] = 0.42416936f;
//	        sa[9] = -0.30485758f;
//	        sa[10] = -0.39702874f;
//	        sa[11] = -0.5027239f;
//	        sa[12] = -1.2925403f;
//	        sa[13] = -0.042172775f;
//	        sa[14] = -0.11329215f;
//	        sa[15] = -0.59738386f;
//	        sa[16] = -1.145578f;
//	        sa[17] = -1.6385534f;
//	        sa[18] = -0.99307036f;
//	        sa[19] = -0.8013625f;
//	        sa[20] = 2.5005078f;
//	        sa[21] = -0.49292406f;
//	        sa[22] = -0.7523717f;
//	        sa[23] = 0.10084346f;
//	        sa[24] = 0.55504125f;
//	        sa[25] = -0.2140213f;
//	        sa[26] = 3.0715084f;
//	        sa[27] = 1.7717962f;
//	        sa[28] = -2.813957f;
//	        sa[29] = 0.34212676f;
//	        sa[30] = 0.10428396f;
//	        sa[31] = -0.37901172f;
//	        sa[32] = -0.45934987f;
//	        sa[33] = 1.7254667f;
//	        sa[34] = -0.26770493f;
//	        sa[35] = -0.2683969f;
//	        sa[36] = 0.8930957f;
//	        sa[37] = 0.15974958f;
//	        sa[38] = 0.7266286f;
//	        sa[39] = -0.109662175f;
//	        sa[40] = 0.9136836f;
//	        sa[41] = -0.9927468f;
//	        sa[42] = -0.7575887f;
//	        sa[43] = 0.47051284f;
//	        sa[44] = 0.45618382f;
//	        sa[45] = -0.12782429f;
//	        sa[46] = -0.4279933f;
//	        sa[47] = -1.0130155f;
//	        sa[48] = -1.277103f;
//	        sa[49] = -0.49467915f;
//	        sa[50] = 0.13862042f;
//	        sa[51] = 0.41338181f;
//	        sa[52] = 0.67501265f;
//	        sa[53] = -0.709971f;
//	        sa[54] = 0.547309f;
//	        sa[55] = 0.67063385f;
//	        sa[56] = -0.47796226f;
//	        sa[57] = -0.14162432f;
//	        sa[58] = 0.6685659f;
//	        sa[59] = -0.026324749f;
//	        sa[60] = -0.12327161f;
//	        sa[61] = -0.13819547f;
//	        sa[62] = -0.46753037f;
//	        sa[63] = -0.8310181f;
//	        sa[64] = -0.07581086f;
//	        sa[65] = -0.18851243f;
//	        sa[66] = 0.37084985f;
//	        sa[67] = -0.6514044f;
//	        sa[68] = -0.3480243f;
//	        sa[69] = 0.019786006f;
//	        sa[70] = -0.03672974f;
//	        sa[71] = 0.23782843f;
//	        sa[72] = 0.642239f;
//	        sa[73] = -0.06403497f;
//	        sa[74] = -0.42111582f;
//	        sa[75] = -1.4481282f;
//	        sa[76] = 0.33622283f;
//	        sa[77] = 0.09357191f;
//	        sa[78] = -0.8965574f;
//	        sa[79] = -0.4687022f;
//	        sa[80] = 0.7498913f;
//	        sa[81] = -0.99459213f;
//	        sa[82] = -1.3841381f;
//	        sa[83] = 0.9651896f;
//	        sa[84] = 0.35435233f;
//	        sa[85] = 0.23193984f;
//	        sa[86] = 1.2868369f;
//	        sa[87] = 0.15470658f;
//	        sa[88] = -0.45139116f;
//	        sa[89] = 7.443451E-4f;
//	        sa[90] = 1.7442088f;
//	        sa[91] = -1.372556f;
//	        sa[92] = 0.026472598f;
//	        sa[93] = 0.037702993f;
//	        sa[94] = -2.1221533f;
//	        sa[95] = -0.51871216f;
//	        sa[96] = 0.70873916f;
//	        sa[97] = -0.21543264f;
//	        sa[98] = 0.44345745f;
//	        sa[99] = -1.596332f;
//	    }
//	  }
//	}
//	// The class representing training column names
//	class NamesHolder_DeepLearning_model_R_1481832873762_1613 implements java.io.Serializable {
//	  public static final String[] VALUES = new String[10];
//	  static {
//	    NamesHolder_DeepLearning_model_R_1481832873762_1613_0.fill(VALUES);
//	  }
//	  static final class NamesHolder_DeepLearning_model_R_1481832873762_1613_0 implements java.io.Serializable {
//	    static final void fill(String[] sa) {
//	      sa[0] = "ATG_CIS";
//	      sa[1] = "ATG_TRANS";
//	      sa[2] = "NVS_NR_hER";
//	      sa[3] = "OT_ER_ERaERa_0480";
//	      sa[4] = "OT_ER_ERaERa_1440";
//	      sa[5] = "OT_ER_ERaERb_0480";
//	      sa[6] = "OT_ER_ERaERb_1440";
//	      sa[7] = "OT_ER_ERbERb_0480";
//	      sa[8] = "OT_ER_ERbERb_1440";
//	      sa[9] = "TOX21_ERa_BLA_Agonist";
//	    }
//	  }
//	}
//
//
