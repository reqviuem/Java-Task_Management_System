public class Image extends AbstractContent{

    public Image(String content) {
        super(content);
    }

    @Override
    public TypeOfContent getContentType() {
        return TypeOfContent.IMAGE;
    }


}
