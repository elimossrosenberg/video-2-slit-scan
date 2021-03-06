package com.andrewringler.slitscan;

public class SlitLocationKeyframe implements Comparable<SlitLocationKeyframe> {
	private final float positionInVideo; // [0..1] percentage
	
	// [0..1] percentage left-to-right for vertical slice
	// percentage top-to-bottom for horizontal slice
	private final float locationInFrame;
	
	private final boolean deletable;
	
	public SlitLocationKeyframe(float positionInVideo, float locationInFrame) {
		this(positionInVideo, locationInFrame, true);
	}
	
	public SlitLocationKeyframe(float positionInVideo, float locationInFrame, boolean deletable) {
		this.positionInVideo = positionInVideo;
		this.locationInFrame = locationInFrame;
		this.deletable = deletable;
	}
	
	public float getPositionInVideo() {
		return positionInVideo;
	}
	
	public float getLocationInFrame() {
		return locationInFrame;
	}
	
	public boolean isDeletable() {
		return deletable;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(positionInVideo);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SlitLocationKeyframe other = (SlitLocationKeyframe) obj;
		if (Float.floatToIntBits(positionInVideo) != Float.floatToIntBits(other.positionInVideo))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(SlitLocationKeyframe o) {
		return Float.valueOf(positionInVideo).compareTo(o.positionInVideo);
	}
	
	public SlitLocationKeyframe withNewLocationInFrame(float newLocationInFrame) {
		return new SlitLocationKeyframe(positionInVideo, newLocationInFrame, deletable);
	}
	
	@Override
	public String toString() {
		return "SlitLocationKeyframe [positionInVideo=" + positionInVideo + ", locationInFrame=" + locationInFrame + ", deletable=" + deletable + "]";
	}
}
