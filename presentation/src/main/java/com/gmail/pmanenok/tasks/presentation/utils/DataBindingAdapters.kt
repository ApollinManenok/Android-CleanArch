package com.gmail.pmanenok.tasks.presentation.utils

import android.databinding.BindingAdapter
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.gmail.pmanenok.tasks.R
import com.gmail.pmanenok.tasks.app.PicassoCircleTransformation
import com.squareup.picasso.Picasso

@BindingAdapter("src")
fun setSrc(view: ImageView, url: String?) {
    if (url == "" || url == null) {
        Picasso.get().load(R.drawable.default_user).into(view)
    } else {
        Picasso.get().load(url).transform(PicassoCircleTransformation()).into(view)
    }
}

/*@BindingAdapter("android:hint")
fun setHint(view: EditText, value: Int) {
    view.hint = value.toString()
}*/

@BindingAdapter("visibility")
fun View.visidility(visibility: Boolean) {
    this.visibility = if (visibility) View.VISIBLE else View.GONE
}

//[kapt] An exception occurred: android.databinding.tool.util.LoggedErrorException: Found data binding errors.
//****/ data binding error ****msg:Could not find accessor com.gmail.pmanenok.tasks.presentation.screen.student.details.StudentDetailsViewModel.url
//file:C:\Users\Palina\AndroidStudioProjects\Tasks\presentation\src\main\res\layout\fragment_student_details.xml
//loc:69:29 - 69:41
//****\ data binding error ****
//
//	at android.databinding.tool.processing.Scope.assertNoError(Scope.java:112)
//	at android.databinding.annotationprocessor.ProcessDataBinding.doProcess(ProcessDataBinding.java:109)
//	at android.databinding.annotationprocessor.ProcessDataBinding.process(ProcessDataBinding.java:73)
//	at org.jetbrains.kotlin.kapt3.base.ProcessorWrapper.process(annotationProcessing.kt:99)
//	at com.sun.tools.javac.processing.JavacProcessingEnvironment.callProcessor(JavacProcessingEnvironment.java:794)
//	at com.sun.tools.javac.processing.JavacProcessingEnvironment.access$200(JavacProcessingEnvironment.java:91)
//	at com.sun.tools.javac.processing.JavacProcessingEnvironment$DiscoveredProcessors$ProcessorStateIterator.runContributingProcs(JavacProcessingEnvironment.java:627)
//	at com.sun.tools.javac.processing.JavacProcessingEnvironment$Round.run(JavacProcessingEnvironment.java:1033)
//	at com.sun.tools.javac.processing.JavacProcessingEnvironment.doProcessing(JavacProcessingEnvironment.java:1198)
//	at com.sun.tools.javac.main.JavaCompiler.processAnnotations(JavaCompiler.java:1170)
//	at com.sun.tools.javac.main.JavaCompiler.processAnnotations(JavaCompiler.java:1068)
//	at org.jetbrains.kotlin.kapt3.base.AnnotationProcessingKt.doAnnotationProcessing(annotationProcessing.kt:55)
//	at org.jetbrains.kotlin.kapt3.base.AnnotationProcessingKt.doAnnotationProcessing$default(annotationProcessing.kt:27)
//	at org.jetbrains.kotlin.kapt3.AbstractKapt3Extension.runAnnotationProcessing(Kapt3Extension.kt:213)
//	at org.jetbrains.kotlin.kapt3.AbstractKapt3Extension.analysisCompleted(Kapt3Extension.kt:178)
//	at org.jetbrains.kotlin.kapt3.ClasspathBasedKapt3Extension.analysisCompleted(Kapt3Extension.kt:96)
//	at org.jetbrains.kotlin.cli.jvm.compiler.TopDownAnalyzerFacadeForJVM$analyzeFilesWithJavaIntegration$2.invoke(TopDownAnalyzerFacadeForJVM.kt:95)
//	at org.jetbrains.kotlin.cli.jvm.compiler.TopDownAnalyzerFacadeForJVM.analyzeFilesWithJavaIntegration(TopDownAnalyzerFacadeForJVM.kt:105)
//	at org.jetbrains.kotlin.cli.jvm.compiler.TopDownAnalyzerFacadeForJVM.analyzeFilesWithJavaIntegration$default(TopDownAnalyzerFacadeForJVM.kt:82)
//	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler$analyze$1.invoke(KotlinToJVMBytecodeCompiler.kt:375)
//	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler$analyze$1.invoke(KotlinToJVMBytecodeCompiler.kt:67)
//	at org.jetbrains.kotlin.cli.common.messages.AnalyzerWithCompilerReport.analyzeAndReport(AnalyzerWithCompilerReport.kt:107)
//	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.analyze(KotlinToJVMBytecodeCompiler.kt:366)
//	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli(KotlinToJVMBytecodeCompiler.kt:120)
//	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:161)
//	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:57)
//	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.java:96)
//	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.java:52)
//	at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:93)
//	at org.jetbrains.kotlin.daemon.CompileServiceImpl$compile$1$1$2.invoke(CompileServiceImpl.kt:441)
//	at org.jetbrains.kotlin.daemon.CompileServiceImpl$compile$1$1$2.invoke(CompileServiceImpl.kt:101)
//	at org.jetbrains.kotlin.daemon.CompileServiceImpl$doCompile$$inlined$ifAlive$lambda$2.invoke(CompileServiceImpl.kt:1020)
//	at org.jetbrains.kotlin.daemon.CompileServiceImpl$doCompile$$inlined$ifAlive$lambda$2.invoke(CompileServiceImpl.kt:101)
//	at org.jetbrains.kotlin.daemon.common.DummyProfiler.withMeasure(PerfUtils.kt:137)
//	at org.jetbrains.kotlin.daemon.CompileServiceImpl.checkedCompile(CompileServiceImpl.kt:1062)
//	at org.jetbrains.kotlin.daemon.CompileServiceImpl.doCompile(CompileServiceImpl.kt:1019)
//	at org.jetbrains.kotlin.daemon.CompileServiceImpl.compile(CompileServiceImpl.kt:440)
//	at sun.reflect.GeneratedMethodAccessor121.invoke(Unknown Source)
//	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//	at java.lang.reflect.Method.invoke(Method.java:498)
//	at sun.rmi.server.UnicastServerRef.dispatch(UnicastServerRef.java:346)
//	at sun.rmi.transport.Transport$1.run(Transport.java:200)
//	at sun.rmi.transport.Transport$1.run(Transport.java:197)
//	at java.security.AccessController.doPrivileged(Native Method)
//	at sun.rmi.transport.Transport.serviceCall(Transport.java:196)
//	at sun.rmi.transport.tcp.TCPTransport.handleMessages(TCPTransport.java:568)
//	at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run0(TCPTransport.java:826)
//	at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.lambda$run$0(TCPTransport.java:683)
//	at java.security.AccessController.doPrivileged(Native Method)
//	at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run(TCPTransport.java:682)
//	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
//	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
//	at java.lang.Thread.run(Thread.java:745)