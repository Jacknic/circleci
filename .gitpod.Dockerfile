FROM gitpod/workspace-full


ENV ANDROID_HOME=/home/gitpod/android-sdk-linux \
    PATH=$ANDROID_HOME/tools:$PATH

USER root

RUN curl https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    apt-get update && \
    apt-get -y install build-essential libkrb5-dev gcc make && \
    apt-get clean && \
    apt-get -y autoremove && \
    apt-get -y clean && \
    rm -rf /var/lib/apt/lists/*;

USER gitpod

RUN cd /home/gitpod && \
    wget --output-document=android-sdk-tools.zip --quiet https://dl.google.com/android/repository/sdk-tools-linux-4333796.zip && \
    unzip android-sdk-tools.zip -d $ANDROID_HOME/ && rm android-sdk-tools.zip;
