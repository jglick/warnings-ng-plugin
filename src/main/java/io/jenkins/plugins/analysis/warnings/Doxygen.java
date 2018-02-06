package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.hm.hafner.analysis.parser.DoxygenParser;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;

import hudson.Extension;

/**
 * Provides a parser and customized messages for Doxygen.
 *
 * @author Ullrich Hafner
 */
public class Doxygen extends StaticAnalysisTool {
    static final String ID = "doxygen";

    /** Creates a new instance of {@link Doxygen}. */
    @DataBoundConstructor
    public Doxygen() {
        // empty constructor required for stapler
    }

    @Override
    public DoxygenParser createParser() {
        return new DoxygenParser();
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
            return Messages.Warnings_Doxygen_ParserName();
        }
    }
}
