//
//  CALayer+XibConfiguration.h
//  Spend1
//
//  Created by Jaehwan Park on 2/28/15.
//  Copyright (c) 2015 Jaehwan Park. All rights reserved.
//
#import <QuartzCore/QuartzCore.h>
#import <UIKit/UIKit.h>

@interface CALayer(XibConfiguration)

// This assigns a CGColor to borderColor.
@property(nonatomic, assign) UIColor* borderUIColor;


@end