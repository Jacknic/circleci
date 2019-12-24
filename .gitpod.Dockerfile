FROM gitpod/workspace-full


ENV ANDROID_HOME=/home/gitpod/android-sdk-linux \
    ANDROID_SDK_TOOLS = "sdk-tools-linux-4333796.zip" \
    PATH=$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin:$PATH

USER root

RUN apt-get update && \
    apt-get --quiet install --yes wget tar unzip lib32stdc++6 lib32z1 \
    apt-get clean && \
    apt-get -y autoremove && \
    apt-get -y clean && \
    rm -rf /var/lib/apt/lists/*;

USER gitpod

RUN cd /home/gitpod && \
    wget --output-document=${ANDROID_SDK_TOOLS} --quiet https://dl.google.com/android/repository/${ANDROID_SDK_TOOLS} && \
    unzip -d ${ANDROID_HOME} ${ANDROID_SDK_TOOLS} && rm ${ANDROID_SDK_TOOLS};

RUN echo y | ${ANDROID_HOME}/tools/bin/sdkmanager "platforms;android-28" > /dev/null \
    echo y | $ANDROID_HOME/tools/bin/sdkmanager "platform-tools" > /dev/null \
    echo y | $ANDROID_HOME/tools/bin/sdkmanager "build-tools;28.0.3" > /dev/null \
    yes | $ANDROID_HOME/tools/bin/sdkmanager --licenses > /dev/null;