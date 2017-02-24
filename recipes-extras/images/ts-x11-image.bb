SUMMARY = "TS X11 Image"

IMAGE_FEATURES += "x11-base package-management ssh-server-openssh tools-debug tools-profile eclipse-debug nfs-client tools-sdk"

IMAGE_INSTALL += "packagegroup-core-boot \
	packagegroup-core-buildessential \
	packagegroup-core-full-cmdline \
	packagegroup-machine-base \
	packagegroup-qt5-toolchain-target \
	alsa-utils-alsactl \
	alsa-utils-alsamixer \
	alsa-utils-amixer \
	alsa-utils-aplay \
	alsa-utils-speakertest \
	bash-completion \
	boost \
	canutils \
	chromium \
	cinematicexperience \
	clutter-1.0-examples \
	curl \
	devmem2 \
	e2fsprogs \
	eglinfo-x11 \
	espeak \
	fbgrab \
	fbset \
	fontconfig \
	freetype \
	git \
	gst1.0-fsl-plugin \
	gtk+3-demo \
	hexedit \
	hostapd \
	i2c-tools \
	imagemagick \
	iotop \
	iperf \
	iw \
	ldd \
	liberation-fonts \
	libmodbus \
	libsocketcan \
	libusb1 \
	lighttpd-module-cgi \
	linux-firmware \
	lsof \
	matchbox-keyboard \
	matchbox-terminal \
	matchbox-wm \
	modemmanager \
	nano \
	nfs-utils \
	nodejs \
	picocom \
	ppp \
	python-core \
	python-ctypes \
	python-dev \
	python-mmap \
	python-modules \
	python-shell \
	python-threading \
	qtdeclarative-qmlplugins \
	qtmultimedia \
	qtquick1 \
	qtquickcontrols-qmlplugins \
	qtwebkit \
	rsync \
	sqlite3 \
	tcpdump \
	ttf-bitstream-vera \
	usb-modeswitch \
	usbutils \
	util-linux-mkfs \
	wireless-tools \
	wpa-supplicant \
	xcursor-transparent-theme \
	xinput-calibrator \
	xterm "

EXTRA_IMAGE_FEATURES = "debug-tweaks"
EXTRA_IMAGEDEPENDS += "qemu-native qemu-helper-native"

LICENSE = "MIT"

inherit core-image 
