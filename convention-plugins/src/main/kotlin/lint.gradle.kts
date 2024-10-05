
import org.jmailen.gradle.kotlinter.tasks.FormatTask
import org.jmailen.gradle.kotlinter.tasks.LintTask

plugins {
    id("org.jmailen.kotlinter")
}

tasks.withType<LintTask> {
    exclude { it.file.path.contains("generated/") }
}

tasks.withType<FormatTask> {
    exclude { it.file.path.contains("generated/") }
}

tasks.register<FormatTask>("ktlint") {
    group = "formatting"
    source(files("src"))
    report.set(file("build/format-report.txt"))
}
