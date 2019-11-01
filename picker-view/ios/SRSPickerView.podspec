
Pod::Spec.new do |s|
  s.name         = "SRSPickerView"
  s.version      = "1.0.0"
  s.summary      = "SRSPickerView"
  s.description  = <<-DESC
                  SRSPickerView
                   DESC
  s.homepage     = "https://github.com/author/SRSPickerView.git"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/SRSPickerView.git", :tag => "master" }
  s.source_files  = "SRSPickerView/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

  
