package org.faboo;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;

import java.util.Arrays;
import java.util.List;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	private Language language;
	private List<FileUpload> fileUpload;
    private final FileUploadField fileUploadField;

    public HomePage(final PageParameters parameters) {
		super(parameters);

		Form form = new Form<HomePage>("form", new CompoundPropertyModel<>(this)) {
            @Override
            protected void onSubmit() {
                super.onSubmit();
                System.out.println("language:"  +language);
                System.out.println("file:" + fileUploadField.getFileUpload().getClientFileName());
            }
        };
		add(form);
		form.setMultiPart(true);
		form.add(new FeedbackPanel("feedback"));

        DropDownChoice<Language> ddc = new DropDownChoice<>("language", Arrays.asList(Language.values()));
        ddc.setRequired(true);
        ddc.setNullValid(true);
        form.add(ddc);

        fileUploadField = new FileUploadField("fileUpload");
        form.add(fileUploadField);

    }


    public enum Language {
	    JAVA, CPLUSSPLUSS, PYTHON, JAVASCRIPT, KOTLIN, TYPESCRIPT;
    }
}
