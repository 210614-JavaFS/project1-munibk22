package com.revature.models;

public class ImageTest {
	private String image;

	public ImageTest() {
		super();
	}

	public ImageTest(String image) {
		super();
		this.image = image;
	}

	@Override
	public String toString() {
		return "ImageTest [image=" + image + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImageTest other = (ImageTest) obj;
		if (image != other.image)
			return false;
		return true;
	}

	public byte[] getImage() {
		return image.getBytes();
	}

	public void setImage(String image) {
		this.image = image;
	}

}
