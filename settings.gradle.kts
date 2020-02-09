rootProject.name = "sunkur-java-samples"

include("fork-join")

fun setBuildFile(project: ProjectDescriptor) {
    project.buildFileName = project.name + ".gradle"
    if(!project.children.isEmpty()){
        project.children.forEach {
            setBuildFile(it)
        }
    }
}

rootProject.children.forEach {
    it.buildFileName = it.name + ".gradle.kts"
}
