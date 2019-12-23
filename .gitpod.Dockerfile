FROM gitpod/workspace-full-vnc


ENV ANDROID_HOME=/home/gitpod/android-sdk-linux \
    FLUTTER_HOME=/home/gitpod/flutter \
    PATH=/usr/lib/dart/bin:$FLUTTER_HOME/bin:$ANDROID_HOME/tools:$PATH

USER root

RUN curl https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    curl https://storage.googleapis.com/download.dartlang.org/linux/debian/dart_stable.list > /etc/apt/sources.list.d/dart_stable.list && \
    apt-get update && \
    apt-get -y install build-essential dart libkrb5-dev gcc make gradle android-tools-adb android-tools-fastboot && \
    apt-get clean && \
    apt-get -y autoremove && \
    apt-get -y clean && \
    rm -rf /var/lib/apt/lists/*;

USER gitpod

RUN cd /home/gitpod && wget -qO flutter_sdk.tar.xz https://storage.flutter-io.cn/flutter_infra/releases/stable/linux/flutter_linux_v1.12.13+hotfix.5-stable.tar.xz \
    && tar -xvf flutter_sdk.tar.xz && rm flutter_sdk.tar.xz && \
    wget -qO android_studio.tar.gz https://dl.google.com/dl/android/studio/ide-zips/3.5.3.0/android-studio-ide-191.6010548-linux.tar.gz && \
    tar -xzvf android_studio.tar.gz && rm -f android_studio.tar.gz && \
    wget --output-document=android-sdk-tools.zip --quiet https://dl.google.com/android/repository/sdk-tools-linux-4333796.zip && \
    unzip android-sdk-tools.zip -d $ANDROID_HOME/ && rm android-sdk-tools.zip;
