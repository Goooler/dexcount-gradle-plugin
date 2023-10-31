package com.getkeepsafe.dexcount

import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.internal.DefaultGradleRunner
import spock.lang.Specification
import spock.lang.TempDir

abstract class BaseSpecification extends Specification {
    @TempDir
    File tempDir

    GradleRunner getGradleRunner() {
        return new TestGradleRunner()
            .withPluginClasspath()
            .withProjectDir(tempDir)
            .withArguments('--configuration-cache', '--stacktrace')
    }

    class TestGradleRunner extends DefaultGradleRunner {
        @Override
        DefaultGradleRunner withArguments(List<String> arguments) {
            return super.withArguments(this.arguments + arguments)
        }

        @Override
        DefaultGradleRunner withArguments(String... arguments) {
            return withArguments(Arrays.asList(arguments))
        }
    }
}
