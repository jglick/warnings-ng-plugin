package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.hm.hafner.analysis.parser.CadenceIncisiveParser;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;

import hudson.Extension;

/**
 * Provides a parser and customized messages for the Cadence Incisive Enterprise Simulator.
 *
 * @author Ullrich Hafner
 */
public class Cadence extends StaticAnalysisTool {
    static final String ID = "cadence";

    /** Creates a new instance of {@link Cadence}. */
    @DataBoundConstructor
    public Cadence() {
        // empty constructor required for stapler
    }

    @Override
    public CadenceIncisiveParser createParser() {
        return new CadenceIncisiveParser();
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
            return Messages.Warnings_CadenceIncisive_ParserName();
        }
    }
}
