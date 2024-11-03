public abstract class AbstractContent implements Content {
    protected final String content;
    public AbstractContent(String content) {
        this.content = content;
    }
    @Override
    public String getContent() {
        return content;
    }
}
