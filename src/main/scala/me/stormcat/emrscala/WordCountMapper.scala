package me.stormcat.emrscala

import org.apache.hadoop.mapreduce.Mapper
import org.apache.hadoop.io.{LongWritable, IntWritable, Text}

class WordCountMapper extends Mapper[LongWritable, Text,  Text, IntWritable] {

  private val one:IntWritable = new IntWritable(1)
  private val word = new Text
  
  protected def map(key:LongWritable, value:Text, context:Context) = {
    val line = value.toString
    line.split("\\t").foreach(s => {
      word.set(s)
      context.write(word, one)
    })
  }
  
}

