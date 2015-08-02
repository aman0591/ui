package streama

import grails.transaction.Transactional

@Transactional
class VideoConverterService {

  def convertToH264(sourceFilePath) {

    def process

    if(Settings.findBySettingsKey('Remove Source After Convert').value == "yes"){
      process = ['./convertVideoH264.sh', sourceFilePath, true].execute()
    }else{
      process = ['./convertVideoH264.sh', sourceFilePath].execute()
    }

    process.in.eachLine { line ->
      log.debug(line)
    }

    log.info('convertToH264 executed with targetFilePath: ' + process.exitValue())
  }
}
