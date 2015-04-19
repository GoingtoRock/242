//
//  ViewController.m
//  Spend1
//
//  Created by Jaehwan Park on 2/19/15.
//  Copyright (c) 2015 Jaehwan Park. All rights reserved.
//

#import "ViewController.h"
#import <QuartzCore/QuartzCore.h>
#import "GradientButton.h"

@interface ViewController ()

@end

@implementation ViewController



- (void)viewDidLoad {
    [super viewDidLoad];
    

    
    // moving spend
    moveObjectTimer = [NSTimer scheduledTimerWithTimeInterval:0.1 target:self selector:@selector(spendMovement) userInfo:nil repeats:NO];
    
    // show buttons after that
    sign_button.alpha = 0.0f;
    login_button.alpha = 0.0f;
    [UIButton animateWithDuration:0.5 delay:3.0 options:0 animations:^{ sign_button.alpha = 1.0f;
    } completion:^(BOOL finished) {sign_button.hidden = NO;}];
    [UIButton animateWithDuration:0.5 delay:3.0 options:0 animations:^{ login_button.alpha = 1.0f;
    } completion:^(BOOL finished) {login_button.hidden = NO;}];
    
    sign_button.layer.cornerRadius = 25;
    login_button.layer.cornerRadius = 25;
    login_button.layer.borderWidth = 1;
    login_button.layer.borderColor = [UIColor whiteColor].CGColor;
        

  
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void)spendMovement {
    
    [UIView animateWithDuration:2.0 animations:^{spend.center = CGPointMake(spend.center.x, spend.center.y - 100);}];
}




@end



