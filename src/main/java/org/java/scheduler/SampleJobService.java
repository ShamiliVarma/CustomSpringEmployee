package org.java.scheduler;

import org.springframework.stereotype.Service;

@Service
public class SampleJobService {

	public void executeSampleJob() {
		System.out.println("In SampleJobService :: executeSampleJob");
	}
}
