package me.stormcat.emrscala

import java.io.IOException;

import org.apache.hadoop.mapreduce.Reducer
import org.apache.hadoop.io.{Text, IntWritable}

class WordCountReducer extends Reducer[Text, IntWritable, Text, IntWritable] {
  
  protected def reduce(key:Text, values:Iterable[IntWritable], context:Context) = {
    val countItems = for (writable <- values) yield writable.get
    context.write(key, new IntWritable(countItems.sum))
  }
  
}