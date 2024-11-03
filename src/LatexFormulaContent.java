public class LatexFormulaContent extends  AbstractContent{
    public LatexFormulaContent(String content) {
        super(content);
    }
    @Override
    public TypeOfContent getContentType() {
        return TypeOfContent.LATEX_FORMULA;
    }

}
