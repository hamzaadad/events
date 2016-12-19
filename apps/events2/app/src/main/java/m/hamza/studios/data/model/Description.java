package m.hamza.studios.data.model;

/**
 * Created by hamzaadad on 12/17/16.
 */


public class Description
{
    private String text;

    private String images;

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getImages ()
    {
        return images;
    }

    public void setImages (String images)
    {
        this.images = images;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [text = "+text+", images = "+images+"]";
    }
}