public class StringContent extends AbstractContent{

    public StringContent(String content) {
        super(content);
    }

    @Override
    public TypeOfContent getContentType() {
        return TypeOfContent.STRING;
    }

}
