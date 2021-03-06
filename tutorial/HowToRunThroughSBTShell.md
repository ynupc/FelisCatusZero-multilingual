# How to run through SBT Shell
I recommend to run FelisCatus Zero through SBT Shell because the build through SBT Shell runs faster than the build from SBT Batch Mode.
> "Note: Running in batch mode requires JVM spinup and JIT each time, so your build will run much slower. For day-to-day coding, we recommend using the sbt shell or Continuous build and test feature described below."  
> quoted from "sbt Reference Manual — Running" (http://www.scala-sbt.org/0.13/docs/Running.html)

So I explain how to run it through SBT Shell.
## Build
### SBT Shell
#### Start SBT Shell
```bash
$ sbt
Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=384m; support was removed in 8.0
[info] Loading project definition from /Users/.../FelisCatusZero/project
[info] Set current project to FelisCatusZero (in build file:/Users/.../FelisCatusZero/)
> 
```
#### Exit SBT Shell
```bash
> exit
$ 
```
#### Reload project after you changed build.sbt, project/build.properties and/or project/plugins.sbt
```bash
> reload
[info] Loading project definition from /Users/.../FelisCatusZero/project
[info] Set current project to FelisCatusZero (in build file:/Users/.../FelisCatusZero/)
> 
```
### System Initialization
#### Initialize
You have to initialize FelisCatus Zero at first.
```bash
> init
[info] Set current project to FelisCatusZero-JCasGen (in build file:/Users/.../FelisCatusZero/)
[info] Running util.JCasGen 
...
[info] Set current project to FelisCatusZero (in build file:/Users/.../FelisCatusZero/)
```
#### Do JCasGen after you changes the type system files under src/main/resources/desc/ts/
```bash
> jcasgen
[info] Set current project to FelisCatusZero-JCasGen (in build file:/Users/.../FelisCatusZero/)
[info] Running util.JCasGen 
...
[info] Set current project to FelisCatusZero (in build file:/Users/.../FelisCatusZero/)
```
#### Clear the run history
```bash
> clearHistory
[info] Running util.HistoryCleaner 
...
```
### Maven Repositories Publishing
Root project depends on four projects: Libraries4UIMA, Libraries, Libraries4JCas and JCasGen.
The root project inherits Scala and Java classes from Libraries4UIMA and Libraries4JCas through their maven repositories.
Also, the Libraries4JCas project inherits Scala classes from Libraries4UIMA and Libraries through their maven repositories and it inherits JCas (Java classes generated by JCasGen).
Therefore, after you edit the non-root projects, you may have to generate the JCas by JCasGen and/or publish maven repositories from three projects: Libraries4UIMA, Libraries and Libraries4JCas before compiling the root project.
#### All Maven Repositories Publishing
You can publish all maven repositories at once as below.
```bash
> publishLibs
[info] Set current project to FelisCatusZeroLibraries4UIMA (in build file:// ...
```
#### Libraries4UIMA Maven Repository Publishing
Librareis4UIMA has helpful Scala classes to develop a UIMA based application.
You can publish the maven repository as below.
```bash
> publishLib4UIMA
[info] Set current project to FelisCatusZeroLibraries4UIMA (in build file:// ...
```

#### Libraries Maven Repository Publishing
Libraries has helpful Scala classes to develop Japanese and/or English language processing.
You can publish the maven repository as below.
```bash
> publishLib
[info] Set current project to FelisCatusZeroLibraries (in build file:// ...
```

#### Libraries4JCas Maven Repository Publishing
Libraries4JCas has helpful Scala classes to develop a UIMA based application depended on FelisCatus Zero's type system.
You can publish the maven repository as below.
```bash
> publishLib4JCas
[info] Set current project to FelisCatusZeroLibraries4JCas (in build file:// ...
```

## Run
Once you initialized FelisCatus Zero, you can do the following runs. Note that a letter 't' in command means 'to'.
### End-to-end run
```bash
> ete
[info] Running uima.cpe.CPERunner 
...
```
### Partial run
#### Run from Information Retriever
```bash
> irt
[info] Running uima.cpe.CPERunner 
...
```
#### Run from Information Retriever to Essay Generator
```bash
> irtag
[info] Running uima.cpe.CPERunner 
...
```
#### Run only Information Retriever
```bash
> ir
[info] Running uima.cpe.CPERunner 
...
```
or
```bash
> irtir
[info] Running uima.cpe.CPERunner 
...
```

If you want to do other partial run, see below.

Pipeline component name|The name in SBT Shell
---|---
Question Analyzer|qa
Information Retriever|ir
Answer Generator|ag
Answer Writer|aw
Answer Evaluator|ae

#### Run though the main method of CPERunner with arguments
The following example is exact same as the above "Run from Information Retriever"
```bash
> run-main uima.cpe.CPERunner -from ir
[info] Running uima.cpe.CPERunner 
...
```
