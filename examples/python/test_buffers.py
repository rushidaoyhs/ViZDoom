#!/usr/bin/env python

#####################################################################
# This script presents different buffers and formats.
# OpenCV is used here to display images, install it or remove any
# references to cv2
# Configuration is loaded from "../../examples/config/basic.cfg" file.
# <episodes> number of episodes are played.
# Random combination of buttons is chosen for every action.
#
# To see the scenario description go to "../../scenarios/README.md"
#####################################################################

from __future__ import print_function

from random import choice
from vizdoom import *

import cv2

game = DoomGame()

# Use other config file if you wish.
game.load_config("../../examples/config/deadly_corridor.cfg")

# game.set_console_enabled(True)
# game.set_window_visible(False)

# Just umcomment desired format for screen buffer (and map buffer).
# The last uncommented will be applied.
# Formats with C (CRCGCB and CBCGCR) were ommited cause they are not cv2 friendly.
# Default format is ScreenFormat.CRCGCB.

game.set_screen_format(ScreenFormat.RGB24)
# game.set_screen_format(ScreenFormat.ARGB32)
# game.set_screen_format(ScreenFormat.GRAY8)

# game.set_screen_format(ScreenFormat.BGR24)
# game.set_screen_format(ScreenFormat.RGBA32)
# game.set_screen_format(ScreenFormat.BGRA32)
# game.set_screen_format(ScreenFormat.ABGR32)

# Raw Doom buffer with palette's values. This one makes no sense in particular
# game.set_screen_format(ScreenFormat.DOOM_256_COLORS)

# Sets resolution for all buffers.
game.set_screen_resolution(ScreenResolution.RES_640X480)

# Enables depth buffer.
game.set_depth_buffer_enabled(True)

# Enables labeling of in game objects labeling.
game.set_labels_buffer_enabled(True)

# Enables buffer with top down map of he current episode/level .
game.set_automap_buffer_enabled(True)
game.set_automap_mode(AutomapMode.OBJECTS)
game.set_automap_rotate(False)
game.set_automap_render_textures(False)

game.set_render_hud(True)
game.set_render_minimal_hud(False)

game.set_mode(Mode.SPECTATOR)
game.init()

actions = [[True, False, False], [False, True, False], [False, False, True]]

episodes = 10
sleep_time = 0.028

for i in range(episodes):
    print("Episode #" + str(i + 1))

    # Not needed for the first episode but the loop is nicer.
    game.new_episode()
    while not game.is_episode_finished():
        # Gets the state and possibly to something with it
        state = game.get_state()
        labels = state.labels

        # Display all the buffers here!

        # Just screen buffer, given in selected format. This buffer is always available.
        screen = state.screen_buffer
        cv2.imshow('ViZDoom Screen Buffer', screen)

        # Depth buffer, always in 8-bit gray channel format.
        # This is most fun. It looks best if you inverse colors.
        depth = state.depth_buffer
        if depth is not None:
            cv2.imshow('ViZDoom Depth Buffer', depth)

        cv2.waitKey(int(sleep_time*1000))

        r = game.make_action(choice(actions))

        state = game.get_state()
        screen2 = state.screen_buffer
        suma = (screen == screen2).sum()
        print(suma, suma == 640*480*3)

        print("State #" + str(state.number))
        print("=====================")

    print("Episode finished!")
    print("************************")

cv2.destroyAllWindows()