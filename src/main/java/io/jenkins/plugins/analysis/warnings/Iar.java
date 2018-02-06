package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.hm.hafner.analysis.parser.IarParser;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;

import hudson.Extension;

/**
 * Provides a parser and customized messages for the IAR C/C++ compiler.
 *
 * @author Ullrich Hafner
 */
public class Iar extends StaticAnalysisTool {
    static final String ID = "iar";

    /** Creates a new instance of {@link Iar}. */
    @DataBoundConstructor
    public Iar() {
        // empty constructor required for stapler
    }

    @Override
    public IarParser createParser() {
        return new IarParser();
    }

    /** Descriptor for this static analysis tool. */
    @Extension
    public static class Descriptor extends StaticAnalysisToolDescriptor {
        public Descriptor() {
            super(ID);
        }

        @Nonnull
        @Override
        public String getDisplayName() {
            return Messages.Warnings_iar_ParserName();
        }
    }
}
