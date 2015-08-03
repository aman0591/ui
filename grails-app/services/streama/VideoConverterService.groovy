package streama

import grails.transaction.Transactional

@Transactional
class VideoConverterService {

  def grailsApplication

  def convertToH264(sourceFilePath) {

    def process

    String convertVideoH264Path = grailsApplication.mainContext.getResource("tools/convertVideoH264.sh").file.toString()

//    process = 'pwd'.execute()
//      process = ["$convertVideoH264Path"].execute()

    if(Settings.findBySettingsKey('Remove Source After Convert').value == "yes"){
      process = ["$convertVideoH264Path", sourceFilePath, true].execute()
    }else{
      process = ["$convertVideoH264Path", sourceFilePath].execute()
    }

    process.in.eachLine { line ->
      log.debug("convertVideoH264: " + line)
    }

    log.info('convertToH264 executed with targetFilePath: ' + process.exitValue())
  }
}
