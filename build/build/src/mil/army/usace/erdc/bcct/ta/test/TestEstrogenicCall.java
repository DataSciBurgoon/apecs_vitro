package mil.army.usace.erdc.bcct.ta.test;

import static org.junit.Assert.*;
import org.junit.Test;
import mil.army.usace.erdc.bcct.ta.model.EstrogenicAEMVitro;

public class TestEstrogenicCall {

	@Test
	public void testScore0() {
		double[] data = {1.000,1.0000,1.0000,1.0000,1.00000,1.00000,1.00000,1.00000};
		double[] preds = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}; 
		EstrogenicAEMVitro aem = new EstrogenicAEMVitro();
		double[] output_scores = aem.score0(data, preds);
		Double[] n2 = new Double[2];
		n2[0] = new Double(aem.ACTIVATION[2][0]);
		n2[1] = new Double(aem.ACTIVATION[2][1]);
		for(double activation : aem.ACTIVATION[2]){
			System.out.println(activation);
		}
		double[] n2d = {0.0, 0.0};
		n2d[0] = n2[0].doubleValue();
		n2d[1] = n2[1].doubleValue();
		double distance1 = Math.sqrt(Math.pow(n2d[0]-n2d[0], 2.0) + Math.pow(n2d[1]-n2d[1], 2.0));
		System.out.println(distance1);
		String call1 = "";
		if(distance1 < 1.35){
			call1 = "estrogenic";
		}
		else{
			call1 = "not estrogenic";
		}
		assert(call1.contentEquals("estrogenic"));
		
		double[] data2 = {-0.7747529, -0.5981583, -0.5590589, 0.7762910, -0.4570237, 0.2713118, 0.5915292, 0.3758949, 0.1770902, -0.4415627};
		double[] preds2 = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}; 
		EstrogenicAEMVitro aem2 = new EstrogenicAEMVitro();
		double[] output_scores2 = aem2.score0(data2, preds2);
//		for(double activation : aem2.ACTIVATION[2]){
//			System.out.println(activation);
//		}
		double[] n2a = aem2.ACTIVATION[2];
		System.out.println(n2a[0]);
		System.out.println(n2a[1]);
		System.out.println(n2[0]);
		System.out.println(n2[1]);
		double distance2 = Math.sqrt(Math.pow(n2a[0]-n2[0], 2.0) + Math.pow(n2a[1]-n2[1], 2.0));
		String call2 = "";
		System.out.println("distance2: " + distance2);
		if(distance2 < 1.35){
			call2 = "estrogenic";
		}
		else{
			call2 = "not estrogenic";
		}
		assert(call2.contentEquals("not estrogenic"));
	}

}
