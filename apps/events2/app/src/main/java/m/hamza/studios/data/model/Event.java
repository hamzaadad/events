package m.hamza.studios.data.model;

/**
 * Created by DevBlaan on 15/12/2016.
 */

public class Event
{
    private String[] tags;

    private String _id;

    private Description description;

    private String name;

    private String __v;

    private String dateAdded;

    private String url;

    public String[] getTags ()
    {
        return tags;
    }

    public void setTags (String[] tags)
    {
        this.tags = tags;
    }

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public Description getDescription ()
    {
        return description;
    }

    public void setDescription (Description description)
    {
        this.description = description;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String get__v ()
    {
        return __v;
    }

    public void set__v (String __v)
    {
        this.__v = __v;
    }

    public String getDateAdded ()
    {
        return dateAdded;
    }

    public void setDateAdded (String dateAdded)
    {
        this.dateAdded = dateAdded;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [tags = "+tags+", _id = "+_id+", description = "+description+", name = "+name+", __v = "+__v+", dateAdded = "+dateAdded+", url = "+url+"]";
    }
}
