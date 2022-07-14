#define _CRT_SECURE_NO_WARNINGS
// Visual studio gives errors on scanf without this line above.
#include <SDL2/SDL.h>
#include <GL/glew.h>

#include <stdio.h>
#include <stdlib.h>

// Julia Garant
// Winter 2021
// 104987469

int SCREEN_WIDTH = 800;
int SCREEN_HEIGHT = 600;

void drawLine(int x1, int y1, int x2, int y2) {
    int x, y;
    float m = (y2 - y1) / (float)(x2 - x1);
    glBegin(GL_POINTS);
        
    if (x1 == x2) { // Vertical line
        for (y = min(y1,y2); y <= (y1,y2); y++) {
            glColor3f(1, 0, 0); // Assigned colour red
            glVertex2i(x1, y);
        }
    }
    else if (y1 == y2) { // Horizontal line    
        for (x = min(x1,x2); x <= max(x1,x2); x++) {
            glColor3f(1, 0.5, 0); // Assigned colour orange
            glVertex2i(x, y1);
        }
    }
    else {
        if (abs(m) <= 1) {
            for (x = x1, y = min(y1,y2); x <= max(x1,x2); x++) {
                glColor3f(1, 1, 0); // Assigned colour yellow
                glVertex2i(x, y);
                y = y + m;
            }
        }
        else {
            for (x = x1, y = min(y1,y2); y <= max(y1,y2); y++) {
                glColor3f(0, 1, 0); // Assigned colour green
                glVertex2i(x, y);
                x = x + 1 / m;
            }
        }
    }
    glEnd();
    glFlush();
}

int main(int argc, char* argv[])
{
    // Initializing SDL
    SDL_Init(SDL_INIT_EVERYTHING);
    SDL_GL_SetAttribute(SDL_GL_CONTEXT_PROFILE_MASK, SDL_GL_CONTEXT_PROFILE_COMPATIBILITY);
    SDL_GL_SetAttribute(SDL_GL_CONTEXT_MAJOR_VERSION, 2);
    SDL_GL_SetAttribute(SDL_GL_CONTEXT_MINOR_VERSION, 1);

    // Creating SDL Window
    SDL_Window* window = SDL_CreateWindow("OpenGL", 100, 100, SCREEN_WIDTH, SCREEN_HEIGHT, SDL_WINDOW_OPENGL);
    if (!window) {
        printf("Cannot create the sdl window: %s", SDL_GetError());
        return -1;
    }
    // Creating GL context for the window, it is required for any gl functions to work
    SDL_GLContext context = SDL_GL_CreateContext(window);
    if (!context) {
        printf("Cannot create OpenGL context, probably the requested version of OpenGL is not supported on your machine.");
        printf("SDL ERROR: %s", SDL_GetError());
        return -1;
    }

    // Initialize GLEW
    GLenum res = glewInit();
    if (res != 0) {
        printf("Cannot initialize the dynamic loading of OpenGL functions.");
        return -1;
    }
    // Initialize OpenGL
    glClearColor(1.0f, 1.0f, 1.0f, 0.0f); // Set clear color to white
    //glColor3f(0.0f, 0.0f, 0.0f); // set the drawing color to black

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0, SCREEN_WIDTH, 0, SCREEN_HEIGHT, 0, 1);
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    glPointSize(4);

    int x1, y1, x2, y2;
    printf("Let's draw a line!\nPlease enter your first point x,y:\n");
    scanf("%d\n%d", &x1, &y1);
    printf("Enter your second point:\n");
    scanf("%d\n%d", &x2, &y2);

    SDL_Event windowEvent;

    while (1)
    {
        if (SDL_PollEvent(&windowEvent))
        {
            if (windowEvent.type == SDL_QUIT) break;
            if (windowEvent.type == SDL_KEYUP &&
                windowEvent.key.keysym.sym == SDLK_ESCAPE) break;
        }

        glClear(GL_COLOR_BUFFER_BIT);

        drawLine(x1,y1,x2,y2);

        SDL_GL_SwapWindow(window);
    }

    SDL_GL_DeleteContext(context);
    SDL_Quit();
    return 0;
}
