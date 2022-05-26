ACCEPT_FSL_EULA = "1"

TUNE_ARCH = "arm"
DISTRO_FEATURES:remove = "wayland "
DISTRO_FEATURES:append = " x11 systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = ""
